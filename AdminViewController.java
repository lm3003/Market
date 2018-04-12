import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class AdminViewController {
	private FrontController frontController;
	private AdminBrowseView adminBrowseView;
	private ListProductsView listProductsView;
	//default constructor
	public AdminViewController(){
		this.frontController = new FrontController();
		this.adminBrowseView = new AdminBrowseView();
		this.listProductsView = new ListProductsView();
	}
	
	
	public void browseProducts(Session session) {
		List<Item> productList = this.frontController.browseProducts(session);
		this.listProductsView.listProductList(productList);
		int input = this.adminBrowseView.getInputFromUser();
		switch(input) {
		case 1:
			manageAdminAndCustomerAccounts(session);
			break;
		case 2:
			browseProducts(session);
			break;
		case 3:
			addProducts(session);
		case 4:
			updateProducts(session);
			break;
		case 5:
			deleteProducts(session);
		case 6:
			System.out.println("Exiting...");
			System.exit(0);
		default:
			System.out.println("Invalid Menu item number! Exiting...");
			System.exit(0);
		}
	}
	
	public void manageAdminAndCustomerAccounts(Session session) {
		int input = this.adminBrowseView.getAdminCustomerAccountInput();
		switch(input) {
		case 1:
			List<User> addUserList = this.adminBrowseView.getAddUserInfo();
			boolean isAdded = this.frontController.addUsers(session, addUserList);
			if(isAdded)
				System.out.println("\nUsers added successfully!!...");
			else
				System.out.println("\nA problem occured!!! Verify inputs and try again");
			break;
		case 2:
			List<User> deleteUserList = this.adminBrowseView.getDeleteUserInfo();
			boolean isDeleted = this.frontController.deleteUsers(session, deleteUserList);
			if(isDeleted)
				System.out.println("\nUsers deleted successfully!!...");
			else
				System.out.println("\nA problem occured!!! Verify inputs and try again");
			break;
		default:
			System.out.println("Incorrect Input. Exiting system...");
			System.exit(0);
		}
		browseProducts(session);
	}
	
	public void addProducts(Session session) {
		List<Item> addProductList = this.adminBrowseView.getAddProductList();
		boolean isAdded = this.frontController.addProducts(session, addProductList);
		if(isAdded)
			System.out.println("\\Added products successfully...Browse available products\\n");
		else
			System.out.println("\nWe are experiencing some problems in our system. Please try again later...\n");
		browseProducts(session);
	}
	
	public void updateProducts(Session session) {
		List<Item> updateProductList = this.adminBrowseView.getUpdateProductList();
		boolean isUpdated = frontController.updateProducts(session, updateProductList);
		if(isUpdated)
			System.out.println("\nUpdate Successful...Browse available products\n");
		else
			System.out.println("\nWe are experiencing some problems in our system. Please try again later...\n");
		browseProducts(session);
	}
	
	public void deleteProducts(Session session) {
		List<Integer> deleteProductIdList= this.adminBrowseView.getDeleteProductIdList();
		boolean isDeleted = this.frontController.deleteProducts(session, deleteProductIdList);
		if(isDeleted)
			System.out.println("Successfuly deleted Items...");
		else
			System.out.println("\nWe are experiencing some problems in our system. Please try again later...\n");
		browseProducts(session);
	}
}
