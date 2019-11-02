/**
 * 
 */
package Busqueda_A;

/**
 * @author Sergio González Guerra
 *
 */
public class Arc {
	
	private Node start_;	// Nodo donde comienza el arco
	private Node end_;		// Nodo donde acaba el arco.
	private double cost_;	// Coste asociado al arco.
	
	// Constructor vacío.
	public Arc() {}
	// Constructor copia.
	public Arc(Arc another) {
		cost_ = another.cost_;
		start_ = new Node(another.start_);
		end_ = new Node(another.end_);
	}
	// Constructor principal.
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
	
	// Devuelve un String con el contenido de la clase.
	public String toString() {
		String cad = "";
		cad += start_.getVal() + " --- " + end_.getVal() + " ( " + cost_ + " )\n";

		return cad;
	}
}
