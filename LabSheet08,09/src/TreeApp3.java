
public class TreeApp3 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.createTree5();
		tree.printTree(tree.getRoot(), 0);
		System.out.println("------------------------------");
		
		//tree.delete(25);
		//tree.printTree(tree.getRoot(), 0);
		//System.out.println("------------------------------");
		
		tree.delete(50);
		System.out.println("Parent = "+tree.parent.data);
		System.out.println("DeleteNode = "+tree.deleteNode.data);
		System.out.println("------------------------------");
		tree.printTree(tree.getRoot(), 0);

	}
}

