/**
 * 
 */
package Busqueda_A;

/**
 * @author Sergio González Guerra
 *
 */
public class Tree {
	
	private TreeNode root_;
	private int maxLevel_;
	private Node finalNode_;
	
	
	public Tree(Node root, Node finalNode) {
		TreeNode tn= new TreeNode(root, 1);
		root_ = tn;
		maxLevel_ = 1;
		finalNode_ = finalNode;
	}
	
	// Setters
	public void addNode(Node n, int level) {
		for (int i = 0; i < maxLevel_ ; i++) {
			
		}
	}
	
	
}
