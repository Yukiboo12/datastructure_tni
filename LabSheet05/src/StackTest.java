
public class StackTest {

	public static void main(String[] args) {
		
		// StackArrayBased num_stack = new StackArrayBased(5);
		StackLinkedList num_stack = new StackLinkedList();
		
		num_stack.push(15);
		num_stack.push(16);
		num_stack.push(17);  //一番上が17になる
		
		// System.out.println(num_stack.peek()); // Data in stack -> [15,16,17]
		
		// Data in stack linked list -> [17,16,15]
		System.out.println("Pop stack = "+ num_stack.pop());
		
		// Data in stack linked list -> [16,15] 
		System.out.println("Pop stack = "+ num_stack.pop());
		
		// System.out.println("Pop stack = "+ num_stack.pop());
		// System.out.println("Peek stack = "+ num_stack.peek());

	}

}
