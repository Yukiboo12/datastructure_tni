
public class Ex05 {

	public static void main(String[] args) {
		
		NumArrayController nums = new NumArrayController();
		nums.display("Display an initail dateset: ");
		
		int[] coppy_nums = new int[nums.getsize()-1];
		
		for (int i=0; i<coppy_nums.length; i++) {
			coppy_nums[i] = nums.getNumArray() [i];
			
		}
		
		nums.setNumbers(coppy_nums);
		nums.display("\n After deleted the Last element: ");

	}

}

