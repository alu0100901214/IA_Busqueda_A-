/**
 * 
 */
package Busqueda_A;

import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
public class Leaf {
	
	private Node node_;
	private ArrayList<Node> succesors_ = new ArrayList<Node>();
	
	public Leaf(Node node) {
		node_ = node;
	}
	
	public Node getNode_() {
		return node_;
	}
	
	public Node getSuccesor(int i) {
		return succesors_.get(i);
	}
}
