/**
 * 
 */
package Busqueda_A;
import java.util.ArrayList;



/**
 * @author Sergio González Guerra
 *
 */
public class Node {
	
	private int val_;
	private double heuristic_;
	private ArrayList<Arc> arches_ = new ArrayList<Arc>(); // Cambiar a ARCOS
	
	public Node() {}
	
	public Node(int val) {
		val_ = val;
	}
	
	// Getters
	public int getVal() { return val_; }
	public ArrayList<Arc> getArches() { return arches_; }
	public double getHeuristic() { return heuristic_; }
	
	// Setters
	public void setVal(int val) { val_ = val; }
	public void addArc(Arc arc) { arches_.add(arc); }
	public void setHeuristic(double heuristic) { heuristic_ = heuristic; }
	
	public String toString() {
		String cad="";
		for (int i = 0; i < arches_.size(); i++) {
			cad += arches_.get(i).toString();
		}
		
		return cad;
	}
	
}
