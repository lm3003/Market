import java.util.Scanner;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class AdminBrowseView {
	Scanner scanner;	
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
	
	private String getInput() {
		this.scanner = new Scanner(System.in);
		String input = scanner.next();
		return input;
	}
	
	public Item getProduct() {
		System.out.print("\nPlease enter the Id of the product you want to update: ");
		int id = Integer.parseInt(getInput());
		Item item = new Item();
		item.setId(id);
		String[] getNewProductDetail = getNewProductDetail();
		item.setName(getNewProductDetail[0]);
		item.setDescription(getNewProductDetail[1]);
		item.setQuantity(getNewProductDetail[2]);
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
		if(!isNumeric(productInfo[2])) {
			System.out.println("======Invalid value entered. Enter a numeric value for quantity.\nPlease enter values again...======");
			return getNewProductDetail();
		}
		System.out.print("\nPlease enter the price of the product:");
		productInfo[3] = getInput();
		return productInfo;
	}
	
	//check if string is numeric value for quantity validation
    private boolean isNumeric(String s) {
    	return s != null && s.matches("[0-9]+");
    }

}
