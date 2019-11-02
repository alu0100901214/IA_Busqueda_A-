/**
 * 
 */
package Busqueda_A;
import java.util.ArrayList;



/**
 * @author Sergio Gonz�lez Guerra
 *
 */
// Clase que representa al Nodo de un Grafo.
public class Node {
	
	private int val_;			// Identificador del nodo.
	private double heuristic_;	// Heur�stica del nodo.
	private ArrayList<Arc> arches_ = new ArrayList<Arc>();	// Lista de arcos sucesores del nodo.
	
	// Constructor vac�o.
	public Node() {}
	// Constructor de copia.
	public Node(Node another) {
		val_ = another.val_;
		heuristic_ = another.heuristic_;
		for (int i = 0; i < arches_.size(); i++) {
			arches_.add(new Arc(another.arches_.get(i)));
		}
	}
	// Constructor principal.
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
	
	// Devuelve un String con el contenido de la clase.
	public String toString() {
		String cad="";
		for (int i = 0; i < arches_.size(); i++) {
			cad += arches_.get(i).toString();
		}
		return cad;
	}
	
}
