import java.util.ArrayList;
import java.util.Scanner;

public final class Lab202 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		int[] initial_numbers = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		for (int i = 0; i < initial_numbers.length; i++) {
			numbers.add(initial_numbers[i]);
		}
		
		System.out.print("Enter element to add at the Last: ");
		numbers.add(scan.nextInt());
		
		System.out.print("Enter element to insert: "); //ที่จะแทรก
		numbers.add(2, scan.nextInt()); // ตัวสุดท้าย
		
		numbers.remove(8); // รองสุดท้าย
		
		numbers.set(0, 7); // ก่อนรองสุดท้าย 
		
		System.out.println("Final ArrayList: " + numbers);

	}

}
