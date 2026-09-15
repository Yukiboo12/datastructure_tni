import java.util.ArrayDeque;
import java.util.Deque;

public class Sorting {

	private int[] array;
	
	public Sorting(int[] array) {
		this.array = array;
	}
			
	public void printSortedData() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		} //end for

	}

	public void bubbleSort() {
		for (int i = 0; i < array.length; i++) { // Loop through all elements
			boolean is_swapped = false;
			for (int j = 0; j < array.length -i -1; j++) { // index = [j]
				if (array[j] > array[j +1]) { // มากไปน้อย >
					// swap element
					// a = array[current_index]
					// b = array[current_index]
					int temp = array[j];
					array[j] = array[j +1]; //[current_index] = [j]
					array[j +1] = temp;
					
					is_swapped = true;
				} //end if
			} //end for
			
			if (is_swapped == false) {
				break;
			}
		}
	}
	
	public void bubbleSort(boolean order) {
		for (int i = 0; i < array.length; i++) { // Loop through all elements
			boolean is_swapped = false;
			for (int j = 0; j < array.length -i -1; j++) { // index = [j]
				if (order == true) {
				if (array[j] < array[j +1]) { // น้อยไปมาก <
					// swap element
					// a = array[current_index]
					// b = array[current_index]
					int temp = array[j];
					array[j] = array[j +1]; //[current_index] = [j]
					array[j +1] = temp;
					
					is_swapped = true;
				} //end if
			} //end for
		}
			
			if (is_swapped == false) {
				break;
			}
		}
	}
	
	public void selectionSort() {
		for (int i = 0; i < array.length - 1; i++) { // Loop through all elements
			// int current_index = i;
			int minimum_Index = i; // สมมติให้ตำแหน่งปัจจุบันมีค่าน้อยที่สุด
			
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[minimum_Index]) {
					minimum_Index = j; // อัปเดตตำแหน่งของตัวที่น้อยกว่า
				}
			}
			// swap the elements of array[i] and array[minimum_Index]
			if (minimum_Index != i) {
				int temp = array[i];
				array[i] = array[minimum_Index];
				array[minimum_Index] = temp;
			}
		}
	}
	
	public void insertionSort() {
		for (int i = 1; i < array.length; i++) { // Loop through all elements
			int key = array[i];
			int walker_index = i - 1; // ตัวเดินย้อนกลับไปเปรียบเทียบทางซ้าย
			
			// วนลูปเปรียบเทียบกับตัวทางซ้าย ถ้าตัวซ้ายมากกว่า ให้ขยับหลบไปทางขวา
			while (walker_index >= 0 && array[walker_index] > key) {
				array[walker_index + 1] = array[walker_index];
				walker_index = walker_index -1; //walker--; ใช่แบบนี้ได้
			}
			array[walker_index + 1] = key; // นำ Key ไปวางในตำแหน่งที่ถูกต้อง
		}
	}
	
	public void quicksort() {
		Deque<Integer> stack = new ArrayDeque<Integer>(); // สร้าง Stack สำหรับเก็บคู่ของขอบเขตช่วง (low และ high)
		stack.push(array.length -1); // ใส่ช่วงเริ่มต้น (ตัวสุดท้าย ถึง 0) ลงใน stack
		stack.push(0);
		
		while (!stack.isEmpty()) { // ทำงานวนลูปจนกว่า Stack จะว่างเปล่า
			int low = stack.pop(); //ต้องเก็บใน low ก่อน
			int high = stack.pop();
			
			if (high-low < 1) {  // ถ้าช่วงมีสมาชิกน้อยกว่า 2 ตัว ให้ข้ามไปรอบถัดไป
				continue;
			}
			// ทำการ partition แล้วรับจุดตัด j กลับมา
			int j = partition(low, high);
			
			stack.push(high); 
			stack.push(j + 1); // Push ช่วงฝั่งขวา (j + 1 ถึง high)
			
			stack.push(j);
			stack.push(low); // Push ช่วงฝั่งซ้าย (low ถึง j)
		}
	}
	
	private int partition(int low,int high) {
		int pivot = array[low]; // กำหนด pivot เป็นตัวแรก
		int i = low; //index
		int j = high; //elements
		while (true) {
			while (array[i] < pivot) { // เลื่อน i ไปทางขวา ตราบใดที่ข้อมูลน้อยกว่า pivot
				i++;
			}
			
			while (array[j] > pivot) { // เลื่อน j ไปทางซ้าย ตราบใดที่ข้อมูลมากกว่า pivot
				j--;
			}
			if (i >= j) { // ถ้า i กับ j เดินสวนกันหรือเจอกัน ให้หยุดลูปและคืนค่าตำแหน่ง j
				break;
			}
			// สลับค่าระหว่างตำแหน่ง i และ j
			int temp = array[i]; 
			array[i] = array[j];
			array[j] = temp;
			
			i++; // สลับค่าระหว่างตำแหน่ง i และ j
			j--;
		}
		return j;
	}
}

