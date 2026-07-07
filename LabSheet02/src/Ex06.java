
public class Ex06 {

	public static void main(String[] args) {
		
		NumArrayController nums = new NumArrayController();
		nums.display("Display an initail dateset: ");
		
		int[] coppy_nums = new int[nums.getsize()-1];
		
		// coppy nums index 0-1 to coppy_num index 0-1
		for (int i=0; i<2; i++) {
			coppy_nums[i] = nums.getNumArray() [i];
		}
		
		// coppy nums index 3-6 to coppy_num index 2-5
		for (int i=2+1; i<nums.getsize(); i++) {
			coppy_nums[i-1] = nums.getNumArray() [i];
		}
		
		nums.setNumbers(coppy_nums);
		nums.display("\n After deleted data in index 2: ");
		
	}

}
