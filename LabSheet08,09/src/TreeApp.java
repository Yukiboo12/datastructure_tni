
public class TreeApp {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		System.out.println("------------------------------");
		System.out.println("Binary Tree from createTree1()");
		System.out.println("------------------------------");
		
		tree.createTree1();
		tree.printTree(tree.getRoot(), 0);
		
		System.out.println("------------------------------");
		System.out.println("Binary Tree from createTree2()");
		System.out.println("------------------------------");
		
		tree.createTree2();
		tree.printTree(tree.getRoot(), 0);
		
		System.out.println("------------------------------");
		System.out.println("Binary Tree from createTree3()");
		System.out.println("------------------------------");
		
		tree.createTree3();
		tree.printTree(tree.getRoot(), 0);

	}

}