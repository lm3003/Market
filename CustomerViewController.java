import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class CustomerViewController{
	private FrontController frontController;
	private CustomerBrowseView customerBrowseView;
	private ListProductsView listProductsView;
	//default constructor
	public CustomerViewController() {
		this.frontController = new FrontController();
		this.customerBrowseView = new CustomerBrowseView();
		this.listProductsView = new ListProductsView();
	}
	
	public void browseProducts(Session session) {
		List<Item> productList = this.frontController.browseProducts(session);
		this.listProductsView.listProductList(productList);
		int input = this.customerBrowseView.getInputFromUser();
		implementUserSelection(session, input);
	}
	
	private void implementUserSelection(Session session,int input) {
		switch(input) {
		case 1:
			saveProductToCart(session);
			break;
		case 2:
			break;
		default:
			System.out.println("Exiting system....");
			System.exit(0);
		}
	}
	
	public void saveProductToCart(Session session) {
		int productId = this.customerBrowseView.getProductId();
		this.frontController.saveProductToCart(session, productId);
		System.out.println("\nProduct saved to cart successfully...\n");
		viewShoppingCartProducts(session);
	}
	
	public void viewShoppingCartProducts(Session session) {
		List<Item> productList = this.frontController.viewShoppingCartProducts(session);
		if(productList.isEmpty()) {
			System.out.println("Your Cart is empty!");
			return;
		}
		System.out.println("Items in your Cart:");
		this.listProductsView.listProductList(productList);
		int input = this.customerBrowseView.getInputFromUser();
		implementUserSelection(session, input);
	}
	
}