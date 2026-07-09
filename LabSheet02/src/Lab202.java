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
		
		System.out.println("Initial numbers: " + "\n" + numbers);
		
		System.out.print("\nEnter your student ID :");
		String studentId = scan.next();
		
		System.out.print("\nEnter the last digit of your student ID : "); // ต่อท้ายข้อมูลตัวสุดท้ายใน numbers
		numbers.add(scan.nextInt());
		System.out.println(numbers);
		
		System.out.print("\nEnter element to insert (ตัวเลขที่จะแทรกที่) : "); //แทรกเข้าไปใน numbers ที่ตำแหน่งตามเลขสุดท้ายของรหัสนักศึกษา
		numbers.add(10, scan.nextInt()); 
		System.out.println(">> Update : " + numbers);
		
		System.out.print("\nDeleting data at Index :"); //ลบข้อมูลใน numbers โดยลบตำแหน่งตามเลขรองสุดท้ายของรหัสนักศึกษา
		numbers.remove(scan.nextInt()); 
		System.out.println(">> Update : " + numbers);
		
		System.out.print("\nEnter today's date : "); //ปเดตตัวเลขใน numbers โดยตำแหน่งที่อัปเดตตามเลขก่อนรองสุดท้าย...วันที่เรียน วันที่7
		numbers.set(0, scan.nextInt()); 
		System.out.println(">> Update: " + numbers);
		
		System.out.println("\nFinal ArrayList: " + numbers);

	}

}
