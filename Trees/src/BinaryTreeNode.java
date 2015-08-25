
public class BinaryTreeNode<Item> {

	private Item data;
	private BinaryTreeNode<Item> leftNode;
	private BinaryTreeNode<Item> rightNode;
	public Item getData() {
		return data;
	}
	public void setData(Item data) {
		this.data = data;
	}
	public BinaryTreeNode<Item> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode<Item> leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode<Item> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode<Item> rightNode) {
		this.rightNode = rightNode;
	}
	public BinaryTreeNode(Item data){
		this.data=data;
		this.leftNode=null;
		this.rightNode=null;
		}
	
	
	
}
