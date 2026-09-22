
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class linearSearch03 {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BinarySearchTree tree = new BinarySearchTree();
        tree.sampleTree();
        tree.printTree(tree.getRoot(), 0);

        ArrayList<Integer> list = traversal(tree.getRoot()); // นำข้อมูลลง ArrayList แล้วแปลงเป็น Array
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        System.out.println("\nTraversal order : " + list);
        System.out.print("\nEnter target: ");
        int target = scan.nextInt();

        int index = linearSearch(nums, target);

        if (index != -1) {
            System.out.println("The target (" + target + ") at index " + index);
        } else {
            System.err.println("Cannot found " + target + " in this tree");
        }
    }

    public static ArrayList<Integer> traversal(Node root) {  
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Queue<Node> queue = new LinkedList<>(); // สร้าง Queue เพื่อใช้เก็บโหนดตามลำดับชั้น (Level)
        queue.add(root); // เริ่มจากโหนดราก (Root)
        
        while (!queue.isEmpty()) {
            Node current = queue.poll(); // ดึงโหนดที่อยู่คิวแรกสุดออกมา
            list.add(current.data); // เก็บค่าของโหนดนั้นลงใน ArrayList
            
            if (current.left != null) {
            	queue.add(current.left); // ถ้ามีลูกฝั่งซ้าย ให้เอาลูกฝั่งซ้ายเข้าคิวรอไว้
            }
            if (current.right != null) {
            	queue.add(current.right); // ถ้ามีลูกฝั่งขวา ให้เอาลูกฝั่งขวาเข้าคิวรอไว้ตามลำดับ
            }
        }
        return list; // คืนค่า ArrayList ที่เก็บข้อมูลตามลำดับชั้นเรียบร้อยแล้ว
    }

    public static int linearSearch(int[] nums, int target) { 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
