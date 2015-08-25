
/**
 * @author sureshbvn
 *
 *Binary search tree is a generic class to to create binary search tree.
 *
 *Required Files-BinarTreeNode.java
 * @param <Item> 
 */
public class BinarySearchTree<Item> {

	/**
	 * @param rootNode of the binary tree to be printed
	 * prints the binary tree in inorder traversals.
	 */
	private void printBinarySearchTree(BinaryTreeNode<Item> rootNode) {
		BinaryTreeNode<Item> node = rootNode;
		if (node == null)
			return;
		else {
			printBinarySearchTree(rootNode.getLeftNode());
			System.out.println(rootNode.getData());
			printBinarySearchTree(rootNode.getRightNode());
		}

	}

	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(10);

		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(16);

		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(9);

		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(13);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(17);

		node.setLeftNode(node1);
		node.setRightNode(node2);

		node1.setLeftNode(node3);
		node1.setRightNode(node4);

		node2.setLeftNode(node5);
		node2.setRightNode(node6);

		node3.setLeftNode(null);
		node3.setRightNode(null);

		node4.setLeftNode(null);
		node4.setRightNode(null);

		node5.setLeftNode(null);
		node5.setRightNode(null);

		node6.setLeftNode(null);
		node6.setRightNode(null);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.printBinarySearchTree(node);

	}
}
