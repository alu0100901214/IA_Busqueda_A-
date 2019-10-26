/**
 * 
 */
package Busqueda_A;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
public class AStarSearch {
	
	Graph graph_;
	Tree tree_;
	Node nodeEnd_;
	ArrayList<Path> possiblePaths_ = new ArrayList<Path>();
	ArrayList<Node> generated_ = new ArrayList<Node>();
	ArrayList<Node> inspected_ = new ArrayList<Node>();
	
	
	public AStarSearch(File archive1, File archive2, int start, int end) throws IOException{
		
		// Inicio
		graph_ = new Graph(archive1, archive2);
		Node nodeStart = graph_.getNode(start-1);
		Node nodeEnd_ = graph_.getNode(end-1);
		tree_ = new Tree(nodeStart, nodeEnd_);
		
		Path path = new Path(0);
		path.addNode(nodeStart);
		possiblePaths_.add(path);
		generated_.add(nodeStart);
		
		
		// PRUEBA
//		Path path = new Path(200);
//		path.addNode(graph_.getNode(0));
//		System.out.println(tree_);
//		tree_.addNode(graph_.getNode(3), path);
//		System.out.println(tree_);
		// PRUEBA
	}
	
	public void aStar() {
		Path path = new Path(1);
		// Bucle
		while(generated_.size() != 0) {
			if(path.getPathNode(path.getPathSize()-1) == nodeEnd_) {
					System.out.println("Encontrado");
			}else {
				System.out.println("No Encontrado");
				// Generar hijos
				for (int i = 0; i < possiblePaths_.size() ; i++) {
					Node auxNode = possiblePaths_.get(i).getPathNode(path.getPathSize()-1);
					for (int j = 0; j < auxNode.getArchesSize(); j++) {
						
					}
				}
				// Dar el nodo por inspeccionado			
			}
		}
	}
	
	private void generateNodes(Path path) {
		Path auxPath;
		Node lastPathNode = path.getPathNode(path.getPathSize()-1);
		for (int i = 0; i < lastPathNode.getArchesSize() ; i++) {
			// Crear 2 nuevos path con los nodos que correspondan
			auxPath = path;
			auxPath.addNode(lastPathNode.getArche(i).getEnd());
			// Añadir la suma de todos los arcos.
		}
	}
	
	// Getters
	public Graph getGraph() { return graph_; }
}
