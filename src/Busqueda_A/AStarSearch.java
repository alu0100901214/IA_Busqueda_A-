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
	ArrayList<Path> solutions_ = new ArrayList<Path>();
	ArrayList<Node> generated_ = new ArrayList<Node>();
	ArrayList<Node> inspected_ = new ArrayList<Node>();
	private static final double Max = 9999999;
	
	public AStarSearch(File archive1, File archive2, int start, int end) throws IOException{
		
		graph_ = new Graph(archive1, archive2);
		Node nodeStart = graph_.getNode(start-1);
		nodeEnd_ = graph_.getNode(end-1);
		tree_ = new Tree(nodeStart, nodeEnd_);
		
		Path path = new Path(0);
		path.addNode(nodeStart);
		possiblePaths_.add(path);
		generated_.add(nodeStart);
		
		aStar();
	}
	
	public void aStar() {
		double minCost = Max;
		int index = 0;
		int pruebaIndex = 0;
		// BUCLE
		while(pruebaIndex < 5) {
			
			for (int i = 0; i < possiblePaths_.size(); i++) {
				//System.out.println(possiblePaths_.get(i));
				if(possiblePaths_.get(i).getLastPathNode().getVal() == nodeEnd_.getVal()) {
					if (!solutions_.contains(possiblePaths_.get(i)))
						solutions_.add(possiblePaths_.get(i));
				}
			}
			
			
			for (int i = 0; i < possiblePaths_.size(); i++) {
				if((possiblePaths_.get(i).getTotalCost() + possiblePaths_.get(i).getLastPathNode().getHeuristic()) < minCost) {
					minCost = (possiblePaths_.get(i).getTotalCost() + possiblePaths_.get(i).getLastPathNode().getHeuristic());
					index = i;
				}
				
			}
			//System.out.println("MIN: " + minCost);
			expandNode(possiblePaths_.get(index));
			
			minCost = Max;
			index = 0;
			

			pruebaIndex++;
			
		}
		//BUCLE
		System.out.println("SOLUCIONES: ");
		for (int i = 0; i < solutions_.size(); i++) {
			System.out.println(solutions_.get(i));
		}
	}
	
	private void expandNode(Path path) {
		
		Node lastPathNode = path.getLastPathNode();
		Path auxPath = new Path(path);
		
		for (int i = 0; i < lastPathNode.getArchesSize() ; i++) {
			// Crear los nuevos path con los nodos que correspondan
			auxPath.addNode(lastPathNode.getArche(i).getEnd());
			// Añadir la suma de los arcos de cada nodo añadido.
			auxPath.setTotalCost(auxPath.getTotalCost() + lastPathNode.getArche(i).getCost());
			possiblePaths_.add(auxPath);
			
			auxPath = new Path(path);
		}
		possiblePaths_.remove(path);
	}
	
	// Getters
	public Graph getGraph() { return graph_; }
}
