import java.util.Queue;
import java.util.ArrayDeque;


public class LabQueue01 {

	public static void main(String[] args) {
		
		Queue<Integer> q_num = new ArrayDeque<Integer>();
		
		for (int i=101; i<=150; i++) {
			q_num.add(i);
			System.out.println("Enqueue: "+i);
		}
		System.out.println("Queue => "+q_num);
		
		while (q_num.isEmpty() == false) {
			System.out.println("Calling number: "+q_num.peek());
			System.out.println("Providing service number: "+q_num.poll());
		}
		System.out.println("Queue => "+q_num);

	}

}
