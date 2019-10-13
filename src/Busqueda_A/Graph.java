
package Busqueda_A;
import java.util.ArrayList;
/**
 * @author Sergio González Guerra
 *
 */
public class Graph {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();
	
	public Graph(){}
	
	//Getters
	public ArrayList<Node> getNodes() { return nodes_; }
	
	// Setters 
	public void addNode(Node node) { nodes_.add(node); }
	
}
