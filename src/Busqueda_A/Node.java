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
	private ArrayList<Integer> arches_ = new ArrayList<Integer>(); // Cambiar a ARCOS
	
	public Node(int val) {
		val_ = val;
	}
	
	// Getters
	public int getVal() { return val_; }
	public ArrayList<Integer> getArches() { return arches_; }
	
	// Setters
	public void setVal_(int val) { val_ = val; }
	public void addArc(int arc) {
		arches_.add(arc);
	}
}
