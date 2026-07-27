
public class StackLinkedList {
   
   // pointer to the top node
   private Node top;

   // create an empty stack
   public StackLinkedList() {
      top = null;
   }
   
   public boolean isEmpty() {
	   if (top == null) {
		   return true;
	   }
	   return false;
   }
   
   public void push(int value) {
	   Node new_node = new Node(value);
	   if (isEmpty()) {  // same as (isEmpty() == true)
		   top = new_node;
		   
	   } else {
		   new_node.next = top;
		   top = new_node;
	   }
   }
   
   public int pop() {
	   if (isEmpty()) {
		   return -1;
	   } else {
		   Node temp_node = top;
		   int temp_data = temp_node.data;  //top.data
		   top = top.next;
		   temp_node = null;
		   return temp_data;
	   }
	   
   }
   
   public void popAll() {
	   top = null;
   }
   
   public int peek() {
	   if (isEmpty()) {
		   return -1;
	   }
	   return top.data;
}

}