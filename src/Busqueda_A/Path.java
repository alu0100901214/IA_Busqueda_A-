/**
 * 
 */
package Busqueda_A;

import java.util.ArrayList;

/**
 * @author Sergio Gonz�lez Guerra
 *
 */
public class Path {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();
	private double totalCost_;
	private boolean closed_;
	
	public Path() {}
	
	public Path(double totalCost) {
		totalCost_ = totalCost;
		closed_ = false;
	}
	
	public Path(Path another) {
		for (int i = 0; i < another.nodes_.size(); i++) {
			nodes_.add(new Node(another.nodes_.get(i)));
		}
		totalCost_ = another.totalCost_;
		closed_ = another.closed_;
	}
	
	// Getters
	public double getTotalCost() { return totalCost_; }
	public Node getPathNode(int i) { return nodes_.get(i); }
	public int getPathSize() { return nodes_.size(); }
	public Node getLastPathNode() { return nodes_.get(getPathSize()-1); }
	public ArrayList<Node> getNodes() { return nodes_; }
	public boolean getClosed() { return closed_; }
	
	// Setters
	public void addNode(Node n) { nodes_.add(n); }
	public void setTotalCost(double cost) { totalCost_ = cost; }
	public void setNodes ( ArrayList<Node> nodes ) { nodes_ = nodes; }
	public void setClosed (boolean val) { closed_ = val; }
	
	// Cierra el camino en caso de que se cumpla que su �ltimo nodo sea el
	// del comienzo, el del final o no tenga ning�n sucesor.
	public void closeThePath(Node startNode, Node endNode){
		if(nodes_.size() <= 0) {
			closed_ = true;
		}
		
		if(getLastPathNode().getVal() == startNode.getVal()) {
			closed_ = true;
		}
		
		if(getLastPathNode().getVal() == endNode.getVal()) {
			closed_ = true;
		}
	}
	
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
