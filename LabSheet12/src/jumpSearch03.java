
import java.util.ArrayList;
import java.util.Scanner;

public class jumpSearch03 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BinarySearchTree tree = new BinarySearchTree();
        tree.sampleTree();
        tree.printTree(tree.getRoot(), 0);

        // นำข้อมูลลง ArrayList ด้วย Inorder Traversal
        ArrayList<Integer> list = traversal(tree.getRoot());
        
        // แปลงข้อมูลจาก ArrayList มาใส่ใน Array แบบ int[]
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        // แสดงผลข้อมูลที่เรียงลำดับแล้ว
        System.out.println("\nTraversal order " + list);
        
        System.out.print("Enter target: ");
        int target = scan.nextInt();

        int index = jumpSearch(nums, target);

        // แสดงผลลัพธ์การค้นหา
        if (index != -1) {
            System.out.println("The target (" + target + ") at index " + index);
        } else {
            System.err.println("Cannot found " + target + " in this tree");
        }
    }
	
    // ดึงข้อมูลแบบ Inorder (ซ้าย-ราก-ขวา) เพื่อให้ข้อมูลเรียงจากน้อยไปมาก
    public static ArrayList<Integer> traversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    // เมธอดช่วยสำหรับทำ Recursive แบบ Inorder
    private static void inorder(Node node, ArrayList<Integer> list) {
        if (node != null) {
            inorder(node.left, list);  // วนซ้าย
            list.add(node.data);             // เก็บราก
            inorder(node.right, list); // วนขวา
        }
    }

    // เมธอด Jump Search ตามโครงสร้างของอาจารย์ พร้อมปีกกามาตรฐาน
    public static int jumpSearch(int[] nums, int target) {
        int jump_size = (int)Math.floor(Math.sqrt(nums.length));
        int start = 0;
        int m = 0;

        while (m < nums.length) {
            if (target == nums[m]) {
                return m; // เจอพอดีที่จุดกระโดด
            }
            
            if (target > nums[m]) {
                start = m;
                m += jump_size; // กระโดดบวกเพิ่มทีละ jump_size
            } else {
                // ช่วงค้นหาแบบเรียงตัว (Linear Search) ในบล็อกที่แคบลง
                for (int i = start; i < m; i++) {
                    if (target == nums[i]) {
                        return i;
                    }
                }
                return -1; // คืนค่า -1 ป้องกันโปรแกรมติดลูป (Infinite Loop) หากหาไม่เจอ
            }
        }

        // กรณีเป้าหมายมีค่ามาก และ m กระโดดเลยขนาดอาร์เรย์ไปแล้ว
        if (m >= nums.length) {
            for (int i = start; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

}
