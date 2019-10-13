/**
 * 
 */
package Busqueda_A;

/**
 * @author Sergio González Guerra
 *
 */
public class Arc {
	
	private Node start_;
	private Node end_;
	private double cost_;
	
	public Arc() {}
	
	public Arc(Node start, Node end, double cost) {
		start_ = start;
		end_ = end;
		cost_ = cost;
	}
	
	// Getters

	public Node getStart() { return start_; }
	public Node getEnd() { return end_; }
	public double getCost() { return cost_; }
	
	// Setters
	public void setStart(Node start) { start_ = start; }
	public void setEnd(Node end) { end_ = end; }
	public void setCost(double cost) { cost_ = cost; }
	
	public String toString() {
		String cad = "";
		cad += start_.getVal() + " --- " + end_.getVal() + " ( " + cost_ + " )\n";

		return cad;
	}
}
