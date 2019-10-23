/**
 * 
 */
package Busqueda_A;

import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
public class TreeNode {
	
	private Node node_;
	private ArrayList<TreeNode> sucesors_ = new ArrayList<TreeNode>();
	private int level_;
	
	public TreeNode(Node node, int level) {
		node_ = node;
		level_ = level;
	}
	
	// Setters
	public void addSucesor(TreeNode tn) { sucesors_.add(tn); } 
	
}
