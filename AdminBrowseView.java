import java.util.Scanner;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class AdminBrowseView {
	// Ryan: Should this have a scope associated with it?
	// Fixed: I set it to default scope, however it can be set to private as it is not used beyond this class
	
	private Scanner scanner;	
	//default constructor
	public AdminBrowseView() {
	}
	
	// Ryan: Please include useful comments in each file.
	// Fixed: Added useful comments
	
	
	//Menu for Admin to do their functionalities
	public int getInputFromUser() {
		System.out.println("Please make your selection:");
		System.out.println("1. Update an item");
		System.out.println("2. Remove an item");
		System.out.println("3. Exit");
		int input = Integer.parseInt(getInput());
		return input;
	}
	
	//method to get string input from user
	private String getInput() {
		this.scanner = new Scanner(System.in);
		String input = scanner.next();
		return input;
	}
	
	//method of getting product
	public Item getProduct() {
		System.out.print("\nPlease enter the Id of the product you want to update: ");
		int id = Integer.parseInt(getInput());
		Item item = new Item();
		item.setId(id);
		String[] getNewProductDetail = getNewProductDetail();
		item.setName(getNewProductDetail[0]);
		item.setDescription(getNewProductDetail[1]);
		item.setQuantity(Integer.parseInt(getNewProductDetail[2]));
		item.setPrice(Float.parseFloat(getNewProductDetail[3]));
		return item;
	}
	
	
	private String[] getNewProductDetail() {
		String[] productInfo = new String[4];
		System.out.print("\nPlease enter the name of the product: ");
		productInfo[0] = getInput();
		System.out.print("\nPlease enter the description of the product:");
		productInfo[1] = getInput();
		System.out.print("\nPlease enter the quantity of the product:");
		productInfo[2] = getInput();
		System.out.print("\nPlease enter the price of the product:");
		productInfo[3] = getInput();
		return productInfo;
	}
}
