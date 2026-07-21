import java.util.LinkedList;

public class ShoppingCart {

	public static void main(String[] args) {

		LinkedList<String> cart = new LinkedList<String>();
		
		cart.add("Wireless Mouse");
		cart.add("Mechanical Keyboard");
		cart.add("USB-C Hub");
		System.out.println(cart);
		
		cart.add(1,"Mouse Pad"); //6
		System.out.println(cart);
		
		cart.remove(3); //8
		System.out.println(cart);
		
		cart.remove(1); //10
		System.out.println(cart);
		
		cart.add("Monitor"); //12
		System.out.println(cart);
		
		cart.set(2,"Phone Holder"); //14
		System.out.println(cart);
		
		System.out.println(cart.getLast()); //15

	}

}
