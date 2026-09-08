
public class BSTApp1 {

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		
		//ตัวอย่างที่ 3)
		tree.sampleTree1();
		tree.printTree(tree.getRoot(), 0);
		
		System.out.println();
		System.out.println("Minimum Node is " +tree.findMinimum(tree.getRoot()).data);
		
		//Display the data of Maximum Node
		System.out.println("Maximum Node is " +tree.findMaximum(tree.getRoot()).data);
		
		//no.5
		int target = 40;
		System.out.println("Is " +target+" in BST => "+tree.findSpecificData(target));
		
		// no.7
		int delNode = 60;
		tree.searchDeleteNode(delNode);
		System.out.println("Parent is "+tree.getParent().data);
		System.out.println("Delete Node is "+tree.getDeleteNode().data);
		
		
		//no.9
		tree.delete(delNode);
		tree.printTree(tree.getRoot(), 0);

	}

}
