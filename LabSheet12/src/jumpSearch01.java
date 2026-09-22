import java.util.Scanner;

public class jumpSearch01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] nums = {96, 87, 18, 6, 31, 11, 56, 36, 76} ;
		nums = sorting(nums);
		
		System.out.print("\n\nEnter target: ");
        int target = scan.nextInt();
        
        int index = jumpSearch(nums, target);
        
        if (index != -1) {
            System.out.println("The target (" + target + ") at index " + index);
        } else {
            System.err.println("Cannot found " + target + " in the array"); // ใช้ err ให้ข้อความเป็นสีแดง
        }

	}

	public static int[] sorting(int[] nums) {
        Sorting sort = new Sorting(nums);
        sort.quickSort(); // เลือกใช้ quickSort ตามที่โจทย์อนุญาต
        nums = sort.getArray();
        
        System.out.print("Elements after sorting:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        
        return nums;
    }
	
	public static int jumpSearch(int[] nums, int target) {
		int jump_size = (int)Math.floor(Math.sqrt(nums.length));
		int start = 0;
		int m = 0;
		
		while (m < nums.length) {
			if (target == nums[m]) {
				return m; // เจอพอดีที่จุดกระโดด
			}
			if (target > nums[m]) { //กระโดดไปเรื่อยๆ
				start = m;
				m += jump_size; // บวกเพิ่มทีละ jump_size
			} else {
				for (int i = start; i < m; i++) { //ช่วงค้นหาแบบเรียงตัว Linear Search
					if (target == nums[i]) {
						return i;
					}
				}
				return -1;
			}
		}
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
