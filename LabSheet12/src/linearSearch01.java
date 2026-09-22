import java.util.Scanner;

public class linearSearch01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] nums = {96, 87, 18, 6, 31, 11, 56, 36, 76};
		
		System.out.print("Elements : ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums [i]);
		}
		
		System.out.print("\n\nEnter target : ");
		int target = scan.nextInt();
		
		int index = linearSearch(nums, target);
		
		if (index != -1) {
			System.out.print("The target (" + index + ") at index" + index);
		} else {
			System.err.print("Cannot found" + target + "in this array"); //err ให้ข้อความเป็นสีแดง
		}

	}
	
	public static int linearSearch(int[] nums, int target) {
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i; // คืนค่าตำแหน่งที่หาเจอ
			}
		}
		
		return-1; // ถ้าค้นหาไม่เจอให้คืนค่า
	}

}
