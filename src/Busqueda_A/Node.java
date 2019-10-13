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
	private ArrayList<Arc> arches_ = new ArrayList<Arc>(); // Cambiar a ARCOS
	
	public Node() {}
	
	public Node(int val) {
		val_ = val;
	}
	
	// Getters
	public int getVal() { return val_; }
	public ArrayList<Arc> getArches() { return arches_; }
	
	// Setters
	public void setVal_(int val) { val_ = val; }
	public void addArc(Arc arc) { arches_.add(arc); }
	
	public String toString() {
		String cad="";
		for (int i = 0; i < arches_.size(); i++) {
			cad += arches_.get(i).toString();
		}

		return cad;
	}
	
}
