
public class TestApp {

	public static void main(String[] args) {
		
		// ตัวอย่างที่ 3
		int[] nums = {11, 9, 23, 87, 38, 22, 92, 10};
		
		Sorting sort = new Sorting(nums);
		sort.bubbleSort();
		sort.printSortedData();
		
		System.out.println();
		Sorting sort1 = new Sorting(nums);
		sort1.bubbleSort(true);
		sort1.printSortedData();

		System.out.println();
		
		// ข้อ 2
		int[] nums2 = {25, 11, 45, 6, 87, 20, 78, 64};
		
		System.out.println();
		Sorting sort2 = new Sorting(nums2);
		sort2.bubbleSort();
		sort2.printSortedData();
		
		System.out.println();
		Sorting sort3 = new Sorting(nums2);
		sort3.bubbleSort(true);
		sort3.printSortedData();
		
		System.out.println();
		
		// ข้อ 4
		int[] nums3 = {68, 10, 87, 75, 14, 36, 98, 76};
		
		System.out.println();
		Sorting sort4 = new Sorting(nums3);
		sort4.insertionSort();
		sort4.printSortedData();
		
		System.out.println();
		
		//ข้อ 6)
		int[] nums4 = {87, 11, 26, 35, 49, 85, 21, 46};

		System.out.println();
		Sorting sort5 = new Sorting(nums4);
		sort5.quicksort();
		sort5.printSortedData();
		
	}

}
