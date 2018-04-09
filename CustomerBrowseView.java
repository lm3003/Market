import java.util.Scanner;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class CustomerBrowseView {
	// Ryan: Please include useful comments in each file.
	// Fixed: Added useful comments
	
	// Ryan: Should this have a scope associated with it?
	// Fixed: I set it to default scope, however it can be set to private as it is not used beyond this class 
	
	private Scanner scanner;
	public CustomerBrowseView() {
		
	}
	
	//Customer browse menu list
	public int getInputFromUser() {
		System.out.println("Please make your selection:");
		System.out.println("1. Add item to Cart");
		System.out.println("2. Purchase Item in your Cart");
		System.out.println("3. Browse Products");
		System.out.println("4. View Products in your Cart");
		System.err.println("5. Exit");
		int input = Integer.parseInt(getInput());
		return input;
	}
	
	private String getInput() {
		this.scanner = new Scanner(System.in);
		String input = scanner.next();
		return input;
	}
	
	public int[] getProductInfo() {
		int[] productInfo = new int[2];
		System.out.print("\nEnter the product Id you want to add to cart: ");
		productInfo[0] = Integer.parseInt(getInput());
		System.out.print("\nEnter the Quantity you want to add: ");
		productInfo[1] = Integer.parseInt(getInput());
		return productInfo;
	}
}
