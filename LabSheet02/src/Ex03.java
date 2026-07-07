
public class Ex03 {

	public static void main(String[] args) {
		NumArrayController nums = new NumArrayController();
		nums.display("Display an initail dataset: ");
		
		
		int[] coppy_nums = new int[nums.getsize()+1];
		
		//coppy data to 'naums'
		for (int i=0; i<nums.getsize(); i++) {
			coppy_nums[i] = nums.getNumArray() [i];
			
		}
		
		nums.setNumbers(coppy_nums);
		nums.display("\n After added 1 element size: ");
		
		nums.getNumArray() [nums.getsize()-1] = 15;
		
		nums.display("\n After added 15");

	}

}
