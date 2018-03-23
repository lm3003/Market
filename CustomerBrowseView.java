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
	Scanner scanner;
	public CustomerBrowseView() {
		
	}
	
	//Customer browse menu list
	public int getInputFromUser() {
		System.out.println("Please make your selection:");
		System.out.println("1. Add item to Cart");
		System.out.println("2. Purchase Item in Cart");
		System.out.println("3. Exit");
		int input = Integer.parseInt(getInput());
		return input;
	}
	
	private String getInput() {
		this.scanner = new Scanner(System.in);
		String input = scanner.next();
		return input;
	}
	
	public int getProductId() {
		System.out.print("\nPlease enter the Id of the product you want to add to cart: ");
		int id = Integer.parseInt(getInput());
		return id;
	}
}
