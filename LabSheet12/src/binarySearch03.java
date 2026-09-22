
import java.util.ArrayList;
import java.util.Scanner;

public class binarySearch03 {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // สร้าง Object ของต้นไม้และจำลองข้อมูล
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

        System.out.println("\nTraversal order " + list);
        
        System.out.print("\nEnter target: ");
        int target = scan.nextInt();

        int index = binarySearch(nums, target);

        if (index != -1) {
            System.out.println("The target (" + target + ") at index " + index);
        } else {
            System.err.println("Cannot found " + target + " in this tree");
        }
    }

    public static ArrayList<Integer> traversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list); // เรียกใช้เมธอดช่วยทำ Recursive
        return list;
    }
    
    private static void inorder(Node node, ArrayList<Integer> list) {
        if (node != null) {
            inorder(node.left, list); //วนไปเก็บโหนดลูกฝั่งซ้ายสุดก่อน
            
            list.add(node.data); //เก็บค่าโหนดปัจจุบัน
            
            inorder(node.right, list); //วนไปเก็บโหนดลูกฝั่งขวา
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int middle = (low + high) / 2; // หาตำแหน่งกึ่งกลาง
            
            if (nums[middle] == target) {
                return middle; // เจอข้อมูล คืนค่า index
            }
            
            // เปรียบเทียบค่า target กับ ข้อมูลตรงกลางอาร์เรย์
            if (target < nums[middle]) {
                high = middle - 1; // ตัดฝั่งขวาทิ้ง หาฝั่งซ้ายต่อ
            } else {
                low = middle + 1;  // ตัดฝั่งซ้ายทิ้ง หาฝั่งขวาต่อ
            }
        }
        
        return -1; // ถ้าวนลูปจนจบแล้วยังไม่เจอ
    }

}
