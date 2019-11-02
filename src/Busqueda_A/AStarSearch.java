/**
 * 
 */
package Busqueda_A;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
// Clase principal que resuelve el algoritmo de busqueda A*
public class AStarSearch {
	
	Graph graph_;	// Clase que representa a un Grafo
	Node nodeStart_;	// Nodo inicial.
	Node nodeEnd_;		// Nodo final.
	
	ArrayList<Path> possiblePaths_ = new ArrayList<Path>();			// Guarda todos los caminos posibles que se pueden recorrer.
	ArrayList<Path> solutions_ = new ArrayList<Path>();				// Guarda todos los caminos posibles que representen una solución.
	ArrayList<Path> minimumCostSolutions_ = new ArrayList<Path>();	// Guarda los caminos con una solución y de coste mínimo.
	ArrayList<Node> generated_ = new ArrayList<Node>();				// Guarda todos los nodos que se van generando.
	ArrayList<Node> inspected_ = new ArrayList<Node>();				// Guarda todos los nodos que han sido inspeccionados.
	
	private static final double Max = 9999999;
	
	// Constructor que inicializa todas las variables necesarias y comienza la busqueda A*.
	public AStarSearch(File archive1, File archive2, int start, int end) throws IOException{
		
		graph_ = new Graph(archive1, archive2);
		nodeStart_ = graph_.getNode(start-1);
		nodeEnd_ = graph_.getNode(end-1);
		
		Path path = new Path(0);
		path.addNode(nodeStart_);
		possiblePaths_.add(path);
		generated_.add(nodeStart_);
		
		aStar();
	}
	// Función encargada de ejecutar el algoritmo de búsqueda A*.
	public void aStar() {
		
		double minCost = Max;
		int index = 0;
		
		// El bucle no para hasta que se consideren todos los caminos como cerrados o sin salida.
		while(!allPathsClosed()) {
			// Mira de los sucesores de los caminos abiertos cual es el de mínimo coste y lo expande.
			for (int i = 0; i < possiblePaths_.size(); i++) {
				if(!possiblePaths_.get(i).getClosed()) {
					if((possiblePaths_.get(i).getTotalCost() + possiblePaths_.get(i).getLastPathNode().getHeuristic()) < minCost) {
						minCost = (possiblePaths_.get(i).getTotalCost() + possiblePaths_.get(i).getLastPathNode().getHeuristic());
						index = i;
					}
				}
			}
			expandNode(possiblePaths_.get(index));
			minCost = Max;
			index = 0;
			for (int i = 0; i < possiblePaths_.size(); i++) {
				possiblePaths_.get(i).closeThePath(nodeStart_, nodeEnd_);
			}
			
			// Mira si alguno de los caminos es una posible solución.
			for (int i = 0; i < possiblePaths_.size(); i++) {
				if(possiblePaths_.get(i).getLastPathNode().getVal() == nodeEnd_.getVal()) {
					if (!solutions_.contains(possiblePaths_.get(i)))
						solutions_.add(possiblePaths_.get(i));
				}
			}	
		}
		
		// De todas las soluciones, busca la de coste mínimo.
		minCost = Max;
		for (int i = 0; i < solutions_.size() ; i++) {
			if( solutions_.get(i).getTotalCost() < minCost) {
				minCost = solutions_.get(i).getTotalCost();
			}
		}
		for (int i = 0; i < solutions_.size(); i++) {
			if( solutions_.get(i).getTotalCost() == minCost) {
				minimumCostSolutions_.add(solutions_.get(i));
			}
		}		
	}
	// Se encarga de expandir un nodo, abriendo a todos los posibles sucesores que este tenga.
	private void expandNode(Path path) {
		
		Node lastPathNode = path.getLastPathNode();
		Path auxPath = new Path(path);
		
		for (int i = 0; i < lastPathNode.getArchesSize() ; i++) {
			// Comprobamos que el sucesor que queremos añadir no se encuentre ya en el camino.
			if(!repeatedNodeInPath(path, lastPathNode.getArche(i).getEnd())) {
				// Crear los nuevos path con los nodos que correspondan
				auxPath.addNode(lastPathNode.getArche(i).getEnd());
				// Añadir la suma de los arcos de cada nodo añadido.
				auxPath.setTotalCost(auxPath.getTotalCost() + lastPathNode.getArche(i).getCost());
				possiblePaths_.add(auxPath);
				// Añadir el nodo sucesor a la lista de nodos generados
				generated_.add(lastPathNode.getArche(i).getEnd());
				auxPath = new Path(path);
			}
		}
		inspected_.add(path.getLastPathNode());
		possiblePaths_.remove(path);
	}
	// Devuelve falso en caso de que no se encuentre el nodo 'n' en el camino.
	private boolean repeatedNodeInPath(Path path, Node n) {
		boolean check = false;
		for (int i = 0; i < path.getPathSize(); i++) {
			if(path.getPathNode(i).getVal() == n.getVal()) {
				check = true;
			}
		}
		return check;
	}
	// Comprueba que todos los caminos esten cerrador en cuyo caso devuelve verdadero.
	private boolean allPathsClosed() {
		boolean check = true;
		for (int i = 0; i < possiblePaths_.size(); i++) {
			if(!possiblePaths_.get(i).getClosed())
				check = false;
		}
		return check;
	}
	// Escribe en el fichero 'results.txt' los resultados de la ejecución del algoritmo.
	public void writeResults() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("results.txt");
            pw = new PrintWriter(fichero);
            
            pw.println("Nº nodos: " + graph_.getNodes().size());
            pw.println("Nº arcos: " + graph_.getNArches());
            pw.println("Nodo inicial: " + nodeStart_.getVal());
            pw.println("Nodo final: " + nodeEnd_.getVal());
            pw.println("Camino minimo encontrado: " + minimumCostSolutions_.get(0));
            pw.println("Coste minimo: " + minimumCostSolutions_.get(0).getTotalCost());
            pw.println("Nº de nodos generados: " + generated_.size());
            pw.println("Nº de nodos inspeccionados: " + inspected_.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	// Getters
	public Graph getGraph() { return graph_; }
}
