
public class StackArrayBased {
   private int[] stacks;	 	// array to store elements
   private final int MAX_STACK = 50;	// maximum size of stack
   private int top;		 	// index of the top element

   // create an empty stack with a maximum size
   public StackArrayBased() {
      stacks = new int[MAX_STACK];
      top = -1;
   }

   // create an empty stack with a specific size
   public StackArrayBased(int capacity) {  // ใช่ไม่ได้กับ MAX_STACK-1
      stacks = new int[capacity];
      top = -1;
   }
   
   public boolean isEmpty() {
	   if (top == -1) {
		   return true;
	   }
	   return false;
   }
   
   public boolean isFull() {
	   if (top == stacks.length-1) {
	   //if (top == MAX_STACK-1) {  //top=9 stack size=10 --> 0-9
		   return true;
	   }
	   return false;
   }
   
   public boolean push(int new_element) {
	   if (!isFull()) {   // same as if (isFull() == false)
		   top++;
		   stacks[top] = new_element;
		   return true;
	   }
	   return false;
   }
   
   public int peek() { //top()
	   if (!isFull()) { //same as (isEmpty() == false)
		   return stacks[top];
	   }
	   return-1;
   }
   
   public int pop() {
	   if (!isEmpty()) {
		   int top_element = stacks[top];
		   top--;
		   return top_element;
	   }
	   return-1;
   }
   public void popAll() {
	   stacks = new int[MAX_STACK];
	   top = -1;
   }
}
