
public class NumArrayController {
		
		private int[] nums;
		
		public NumArrayController() {
			this.nums = new int[] {23, 67, 8, 91, 45, 12, 78};
		}
		
		public void setNumbers(int[] nums) {
			this.nums = nums;
			
		}
		
		public int getsize() {
			return nums.length;
		}
		
		public int[] getNumArray() {
			return nums;
		}
		
		public void display(String massage) {
			System.out.println(massage);
			
			for (int i=0; i<nums.length; i++) {
				if (i !=0) {
					System.out.print(", ");
				}
				System.out.print(nums[i]);
		}

	}

}
