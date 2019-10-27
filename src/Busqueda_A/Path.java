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
	
	public Path() {}
	
	public Path(double totalCost) {
		totalCost_ = totalCost;
	}
	
	public Path(Path another) {
		for (int i = 0; i < another.nodes_.size(); i++) {
			nodes_.add(new Node(another.nodes_.get(i)));
		}
		this.totalCost_ = another.totalCost_;
	}
	
	// Getters
	public double getTotalCost() { return totalCost_; }
	public Node getPathNode(int i) { return nodes_.get(i); }
	public int getPathSize() { return nodes_.size(); }
	public Node getLastPathNode() { return nodes_.get(getPathSize()-1); }
	public ArrayList<Node> getNodes() { return nodes_; }
	
	// Setters
	public void addNode(Node n) { nodes_.add(n); }
	public void setTotalCost(double cost) { totalCost_ = cost; }
	public void setNodes ( ArrayList<Node> nodes ) { nodes_ = nodes; }
	
	public String toString() {
		String cad = "";
		cad += "TotalCost: " + totalCost_ + "\n";
		for (int i = 0; i < nodes_.size(); i++) {
			cad += nodes_.get(i).getVal() + " - ";
		}
		cad+= "\n";
		return cad;
	}
}
