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
	public void addNode(Node n, Path p) {
		TreeNode auxTreeNode = root_;
		Node auxP;
		for (int i = 0; i < p.getPathSize(); i++) {
			auxP = p.getPathNode(i);
			for (int j = 0; j < auxTreeNode.getSucesorSize() ; j++) {
				if( auxP.getVal() == auxTreeNode.getSucesorTreeNode(j).getNode().getVal() ) {
					auxTreeNode = auxTreeNode.getSucesorTreeNode(j);
				}
			}
		}
		auxTreeNode.addNodeSucesor(n);
	}
	
	public String toString() {
		String cad="";
		cad += root_.toString();
		
		return cad;
	}
}
