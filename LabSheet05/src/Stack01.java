import java.util.Stack;

public class Stack01 {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>(); // สร้าง Stack สำหรับเก็บตู้รถไฟ
		
		int[] cars = {1, 2, 3, 4, 5}; //กำหนดข้อมูลในarray cars
		
		for (int car : cars) { //วนลูป เอาเข้าตู้รถไฟ (Push)
			System.out.println("Siding onto dead-end track: Car " + car);
			stack.push(car);
		}
		
		System.out.println("\nStack -> " + stack + "\n"); // แสดงผลใน Stack ปัจจุบัน
		
		while (!stack.isEmpty()) { // วนลูปเพื่อดึงตู้รถไฟออกจนกว่า Stack จะว่าง (Pop)
			System.out.println("Exiting a dead-end: Car " + stack.pop());
		}
		
		System.out.println("\nStack -> " + stack); //แสดงผลข้อมูลใน Stack หลังจากดึงออกหมดแล้ว

	}

}
