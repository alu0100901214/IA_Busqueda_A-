/**
 * 
 */
package Busqueda_A;

import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
public class Path {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();
	private double totalCost_;
	
	public Path(double totalCost) {
		totalCost_ = totalCost;
	}
	
	// Getters
	public double getTotalCost() { return totalCost_; }
	public Node getPathNode(int i) { return nodes_.get(i); }
	public int getPathSize() { return nodes_.size(); }
	
	// Setters
	public void addNode(Node n) { nodes_.add(n); }
	
}
