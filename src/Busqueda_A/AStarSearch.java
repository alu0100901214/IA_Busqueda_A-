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
		
		aStar();
		
		// PRUEBA
//		Path path = new Path(200);
//		path.addNode(graph_.getNode(0));
//		System.out.println(tree_);
//		tree_.addNode(graph_.getNode(3), path);
//		System.out.println(tree_);
		// PRUEBA
	}
	
	public void aStar() {
		System.out.println("Antes: ");
		for (int i = 0; i < possiblePaths_.size(); i++) {
			System.out.println(possiblePaths_.get(i));
		}
		expandNode(possiblePaths_.get(0));
		
		System.out.println("Después: ");
		for (int i = 0; i < possiblePaths_.size(); i++) {
			System.out.println(possiblePaths_.get(i));
		}
		
//		Path path = new Path(1);
//		// Bucle
//		while(generated_.size() != 0) {
//			if(path.getPathNode(path.getPathSize()-1) == nodeEnd_) {
//					System.out.println("Encontrado");
//			}else {
//				System.out.println("No Encontrado");
//				// Generar hijos
//				for (int i = 0; i < possiblePaths_.size() ; i++) {
//					Node auxNode = possiblePaths_.get(i).getPathNode(path.getPathSize()-1);
//					for (int j = 0; j < auxNode.getArchesSize(); j++) {
//						
//					}
//				}
//				// Dar el nodo por inspeccionado			
//			}
//		}
	}
	
	private void expandNode(Path path) {
		
		Node lastPathNode = path.getPathNode(path.getPathSize()-1);
		Path auxPath = new Path(path);
		
		for (int i = 0; i < lastPathNode.getArchesSize() ; i++) {
			// Crear 2 nuevos path con los nodos que correspondan
			auxPath.addNode(lastPathNode.getArche(i).getEnd());
			// Añadir la suma de todos los arcos.
			auxPath.setTotalCost(auxPath.getTotalCost() + lastPathNode.getArche(i).getCost());
			possiblePaths_.add(auxPath);
			
			auxPath = new Path(path);
		}
		possiblePaths_.remove(path);
	}
	
	// Getters
	public Graph getGraph() { return graph_; }
}
