/**
 * 
 */
package Busqueda_A;

import java.io.File;
import java.io.IOException;

/**
 * @author Sergio Gonz�lez Guerra
 *
 */
public class AStarSearch {
	
	Graph graph_;
	Tree tree_;
	
	
	public AStarSearch(File archive1, File archive2, int start, int end) throws IOException{
		graph_ = new Graph(archive1, archive2);
		Node nodeStart = graph_.getNode(start-1);
		Node nodeEnd = graph_.getNode(end-1);
		// System.out.println(nodeStart.getVal() + " :::: " + nodeEnd.getVal());
		tree_ = new Tree(nodeStart, nodeEnd);
		
		// PRUEBA
		Path path = new Path(200);
		path.addNode(graph_.getNode(0));
		System.out.println(tree_);
		tree_.addNode(graph_.getNode(3), path);
		System.out.println(tree_);
		// PRUEBA
	}
	
	public void aStar() {
		
	}
	
	// Getters
	public Graph getGraph() { return graph_; }
}
