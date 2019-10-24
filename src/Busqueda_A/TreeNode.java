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
	
	// Getters
	public Node getNode() { return node_; }
	public TreeNode getSucesorTreeNode(int i) { return sucesors_.get(i); }
	public int getSucesorSize() { return sucesors_.size(); }
	
	// Setters
	public void addTreeNodeSucesor(TreeNode tn) { sucesors_.add(tn); } 
	public void addNodeSucesor(Node n) { 
		TreeNode tn = new TreeNode(n, level_+1);
		sucesors_.add(tn); 
	} 
	
	public String toString() {
		String cad="";
		cad += node_.getVal() + "\n";
		if(sucesors_.size() != 0) {
			for (int i = 0; i < sucesors_.size() ; i++) {
				cad += sucesors_.get(i).toString();
			}
		}
		return cad;
	}
	
}
