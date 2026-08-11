import java.util.ArrayList;

public class ListReverse1 {

	public static void main(String[] args) {
		ArrayList<Integer> original = new ArrayList<Integer>();
		for (int i=11; i<=20; i++) {
			original.add(i);
		}
		System.out.println("Original Sequence: "+original);
		
		ArrayList<Integer> reversed = reverseList(original);
		System.out.println("Reverse  Sequence: " + reversed);

	}
	public static ArrayList<Integer> reverseList(ArrayList<Integer> original) {
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = original.size()-1; i >= 0; i--) {
			result.add(original.get(i));
			
		}
		return result;
	}

}
