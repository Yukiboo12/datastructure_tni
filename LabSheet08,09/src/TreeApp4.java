
import java.util.Scanner;

public class TreeApp4 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree6();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter data to search: ");
		int search_data = input.nextInt();
		
		tree.printTree(tree.getRoot(), 0);
		System.out.println("----------------------------------------");
		
		// ค้นหาโหนดในต้นไม้
		tree.searchDeleteNode(search_data);
		
		// กรณีที่ไม่พบ N ใน Binary Tree
		if (tree.getSearchNode() == null) {
			System.out.println("Cannot found Node(data ="+search_data + ")");
		} else {
			
			// กรณีที่พบ N: แสดงผลลัพธ์ของ Left Child
			if (tree.getSearchNode().left != null) {
				System.out.println("Left Child: "+ tree.getSearchNode().left.data);
			} else {
				System.out.println("Left Child: No Left Child");
			}
			
			// กรณีที่พบ N: แสดงผลลัพธ์ของ Right Child
			if (tree.getSearchNode().right != null) {
				System.out.println("Right Child: "+ tree.getSearchNode().right.data);
			} else {
				System.out.println("Right Child: No Right child");
			}
			
			// รวจสอบว่าเป็น Leaf Node หรือไม่
			if (tree.getSearchNode().left == null && tree.getSearchNode().right == null) {
				System.out.println(search_data + " is Left Node");
			}else {
				System.out.println(search_data + " is NOT left Node");
			}
		}
	}
}

