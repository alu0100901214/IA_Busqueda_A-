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
 * @author Sergio Gonz�lez Guerra
 *
 */
public class AStarSearch {
	
	Graph graph_;
	Tree tree_;
	Node nodeStart_;
	Node nodeEnd_;
	ArrayList<Path> possiblePaths_ = new ArrayList<Path>();
	ArrayList<Path> solutions_ = new ArrayList<Path>();
	ArrayList<Path> minimumCostSolutions_ = new ArrayList<Path>();
	ArrayList<Node> generated_ = new ArrayList<Node>();
	ArrayList<Node> inspected_ = new ArrayList<Node>();
	private static final double Max = 9999999;
	
	public AStarSearch(File archive1, File archive2, int start, int end) throws IOException{
		
		graph_ = new Graph(archive1, archive2);
		nodeStart_ = graph_.getNode(start-1);
		nodeEnd_ = graph_.getNode(end-1);
		tree_ = new Tree(nodeStart_, nodeEnd_);
		
		Path path = new Path(0);
		path.addNode(nodeStart_);
		possiblePaths_.add(path);
		generated_.add(nodeStart_);
		
		aStar();
	}
	
	public void aStar() {
		double minCost = Max;
		int index = 0;
		
		while(!allPathsClosed()) {
			// Mira de los sucesores de los caminos abiertos cual es el de m�nimo coste y lo expande.
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
			
			// Mira si alguno de los caminos es una posible soluci�n.
			for (int i = 0; i < possiblePaths_.size(); i++) {
				if(possiblePaths_.get(i).getLastPathNode().getVal() == nodeEnd_.getVal()) {
					if (!solutions_.contains(possiblePaths_.get(i)))
						solutions_.add(possiblePaths_.get(i));
				}
			}	
		}
		
		// De todas las soluciones, busca la de coste m�nimo.
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
	
	private void expandNode(Path path) {
		
		Node lastPathNode = path.getLastPathNode();
		Path auxPath = new Path(path);
		
		for (int i = 0; i < lastPathNode.getArchesSize() ; i++) {
			// Comprobamos que el sucesor que queremos a�adir no se encuentre ya en el camino.
			if(!repeatedNodeInPath(path, lastPathNode.getArche(i).getEnd())) {
				// Crear los nuevos path con los nodos que correspondan
				auxPath.addNode(lastPathNode.getArche(i).getEnd());
				// A�adir la suma de los arcos de cada nodo a�adido.
				auxPath.setTotalCost(auxPath.getTotalCost() + lastPathNode.getArche(i).getCost());
				possiblePaths_.add(auxPath);
				// A�adir el nodo sucesor a la lista de nodos generados
				generated_.add(lastPathNode.getArche(i).getEnd());
				auxPath = new Path(path);
			}
		}
		inspected_.add(path.getLastPathNode());
		possiblePaths_.remove(path);
	}
	
	private boolean repeatedNodeInPath(Path path, Node n) {
		boolean check = false;
		for (int i = 0; i < path.getPathSize(); i++) {
			if(path.getPathNode(i).getVal() == n.getVal()) {
				check = true;
			}
		}
		return check;
	}
	
	private boolean allPathsClosed() {
		boolean check = true;
		for (int i = 0; i < possiblePaths_.size(); i++) {
			if(!possiblePaths_.get(i).getClosed())
				check = false;
		}
		return check;
	}
	
	public void writeResults() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("results.txt");
            pw = new PrintWriter(fichero);
            
            pw.println("N� nodos: " + graph_.getNodes().size());
            pw.println("N� arcos: " + graph_.getNArches());
            pw.println("Nodo inicial: " + nodeStart_.getVal());
            pw.println("Nodo final: " + nodeEnd_.getVal());
            pw.println("Camino minimo encontrado: " + minimumCostSolutions_.get(0));
            pw.println("Coste minimo: " + minimumCostSolutions_.get(0).getTotalCost());
            pw.println("N� de nodos generados: " + generated_.size());
            pw.println("N� de nodos inspeccionados: " + inspected_.size());
            
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
