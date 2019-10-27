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
	private ArrayList<Arc> arches_ = new ArrayList<Arc>();
	
	public Node() {}
	
	public Node(Node another) {
		val_ = another.val_;
		heuristic_ = another.heuristic_;
		for (int i = 0; i < arches_.size(); i++) {
			arches_.add(new Arc(another.arches_.get(i)));
		}
	}
	
	public Node(int val) {
		val_ = val;
	}
	
	// Getters
	public int getVal() { return val_; }
	public Arc getArche(int index) { return arches_.get(index); }
	public double getHeuristic() { return heuristic_; }
	public int getArchesSize() { return arches_.size(); }
	
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
