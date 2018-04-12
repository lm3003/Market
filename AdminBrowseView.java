import java.util.ArrayList;
import java.util.List;
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
		System.out.println("1. Manage Admin and Customers \n2. Browse Products"
				+ " \n3. Add Products \n4. Update Products \n5. Delete Products \n6. Exit");
		int input = Integer.parseInt(getInput());
		return input;
	}
	
	//method to get string input from user
	private String getInput() {
		this.scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
	
	//method to manage admin and customer accounts
	public int getAdminCustomerAccountInput() {
		System.out.println("Please make your selection: ");
		System.out.println("1. Add Account \n2. Remove Account \n3. Exit");
		int input = Integer.parseInt(getInput());
		return input;
	}
	
	//method to get add account info
	public List<User> getAddUserInfo() {
		String input = "y";
		List<User> addUserList = new ArrayList<>();
		while(input.equalsIgnoreCase("y")) {
			User user = new User();
			String[] getNewUserDetail = getNewUserDetail();
			user.setUsername(getNewUserDetail[0]);
			user.setPassword(getNewUserDetail[1]);
			user.setRoleType(getNewUserDetail[2]);
			user.setAuthenticated(Integer.parseInt(getNewUserDetail[3]));
			addUserList.add(user);
			System.out.print("\n Add more users? Please enter 'y' or 'n': ");
			input = getInput();
		}
		return addUserList;
	}
	
	//method to get remove account information
	public List<User> getDeleteUserInfo() {
		String input = "y";
		List<User> deleteUserList = new ArrayList<>();
		while(input.equalsIgnoreCase("y")) {
			User user = new User();
			String[] getNewUserDetail = getDeleteUserDetail();
			user.setUsername(getNewUserDetail[0]);
			deleteUserList.add(user);
			System.out.print("\n Delete more users? Please enter 'y' or 'n': ");
			input = getInput();
		}
		return deleteUserList;
	}
	
	//method to get product list
	public List<Item> getAddProductList() {
		String input = "y";
		List<Item> addProductList = new ArrayList<>();
		while(input.equalsIgnoreCase("y")) {
			Item item = new Item();
			String[] getNewProductDetail = getNewProductDetail();
			item.setName(getNewProductDetail[0]);
			item.setDescription(getNewProductDetail[1]);
			item.setQuantity(Integer.parseInt(getNewProductDetail[2]));
			item.setPrice(Float.parseFloat(getNewProductDetail[3]));
			addProductList.add(item);
			System.out.print("\n Add more products? Please enter 'y' or 'n': ");
			input = getInput();
		}
		
		return addProductList;

	}
	
	//method of getting product
	public List<Item> getUpdateProductList() {
		String input = "y";
		List<Item> updateProductList = new ArrayList<>();
		while(input.equalsIgnoreCase("y")) {
			System.out.print("\nPlease enter the Id of the product you want to update: ");
			int id = Integer.parseInt(getInput());
			Item item = new Item();
			item.setId(id);
			String[] getNewProductDetail = getNewProductDetail();
			item.setName(getNewProductDetail[0]);
			item.setDescription(getNewProductDetail[1]);
			item.setQuantity(Integer.parseInt(getNewProductDetail[2]));
			item.setPrice(Float.parseFloat(getNewProductDetail[3]));
			updateProductList.add(item);
			System.out.print("\n Update more products? Please enter 'y' or 'n': ");
			input = getInput();
		}
		
		return updateProductList;
	}
	
	//method to retrieve id or product to delete
	public List<Integer> getDeleteProductIdList() {
		String input = "y";
		List<Integer> deleteProductIdList = new ArrayList<>();
		while(input.equalsIgnoreCase("y")) {
			System.out.print("\nPlease enter the Id of the product you want to delete: ");
			deleteProductIdList.add(Integer.parseInt(getInput()));
			System.out.print("\n Delete more products? Please enter 'y' or 'n': ");
			input = getInput();
		}
		
		return deleteProductIdList;
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
	
	private String[] getNewUserDetail() {
		String[] userInfo = new String[4];
		System.out.print("\nusername: ");
		userInfo[0] = getInput();
		System.out.print("\npassword: ");
		userInfo[1] = getInput();
		System.out.print("\nRoletype (customer or admin): ");
		userInfo[2] = getInput();
		if(!userInfo[2].equalsIgnoreCase("customer") && !userInfo[2].equalsIgnoreCase("admin")) {
			System.out.println("Invalid input. Exiting system...");
			System.exit(0);
		}
		System.out.print("\nisAuthenticated (true or false): ");
		userInfo[3] = getInput();
		if(!userInfo[3].equalsIgnoreCase("true") && !userInfo[3].equalsIgnoreCase("False")) {
			System.out.println("Invalid input. Exiting system...");
			System.exit(0);
		}else {
			if(userInfo[3].equalsIgnoreCase("true"))
				userInfo[3] = "1";
			else
				userInfo[3] = "0";
		}
		return userInfo;
	}
	
	private String[] getDeleteUserDetail() {
		String[] userInfo = new String[1];
		System.out.print("\nusername: ");
		userInfo[0] = getInput();
		return userInfo;
	}
}
