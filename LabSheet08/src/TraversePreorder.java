
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TraversePreorder {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Preorder = " + traversal(tree.getRoot()));
	}

	public static ArrayList<Integer> traversal(Node node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> stack = new ArrayDeque<Node>();
		
		// ถ้าต้นไม้ว่างเปล่า (Root เป็น null) ให้คืนค่า list เปล่าทันที
		if (node == null) {
			return list;
		}
		// นำ Node เริ่มต้น (Root) ใส่เข้าไปใน Stack ก่อน
		stack.push(node);
		
		// วนลูปทำงานจนกว่า Stack จะว่างเปล่า
		while (!stack.isEmpty()) {
			// 1. ดึง Node ตัวบนสุดออกมาเยี่ยมชม (Visit Root)
			Node current = stack.pop();
			list.add(current.data); // นำข้อมูลเก็บใส่ ArrayList
			
			// 2. นำลูก "ขวา" ใส่ Stack ก่อน (เพื่อให้เวลา pop ออกมา ลูกซ้ายจะได้ออกมาก่อนตามกฎ LIFO)
			if (current.right != null) {
				stack.push(current.right);
			}
			// 3. นำลูก "ซ้าย" ใส่ Stack ทีหลัง (จะได้อยู่ด้านบนสุดและถูกหยิบไปประมวลผลก่อน)
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		
		// คืนค่ารายการที่เรียงลำดับแบบ Preorder แล้ว
		return list;
	}

}