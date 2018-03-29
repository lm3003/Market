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
	private List<Item> shoppingCartList;
	//default constructor
	public CustomerViewController() {
		this.frontController = new FrontController();
		this.customerBrowseView = new CustomerBrowseView();
		this.listProductsView = new ListProductsView();
	}
	// Ryan: Please include useful comments in each file.
	// Fixed: Added useful comments
	
	//page controller for customer view interacting with the front controller to send/recieve the required messages 
	public void browseProducts(Session session) {
		List<Item> productList = this.frontController.browseProducts(session);
		this.listProductsView.listProductList(productList);
		int input = this.customerBrowseView.getInputFromUser();
		implementUserSelection(session, input);
	}
	
	private void implementUserSelection(Session session,int input) {
		switch(input) {
		case 1:
			saveProductToCart(session);														// to add a product to cart
			break;
		case 2:
			boolean isPurchaseSuccess = purchaseItems(session);								//purchase items in cart
			if(isPurchaseSuccess) {
				System.out.println("Congrats your order has been shipped...\nView more products to buy");	
			}else {
				System.out.println("We are sorry that the transaction failed, Lets try again...");
			}
			browseProducts(session);
				
			break;
		case 3:
			browseProducts(session);
			break;
		case 4:
			if(!viewShoppingCartProducts(session))
				browseProducts(session);
			break;
		default:
			System.out.println("Exiting system....");
			System.exit(0);
		}
	}
	
	//View products already added to cart
	public boolean viewShoppingCartProducts(Session session) {
		shoppingCartList = this.frontController.viewShoppingCartProducts(session);
		if(shoppingCartList.isEmpty()) {
			System.out.println("Your Cart is empty!");
			return false;
		}
		System.out.println("Items in your Cart:");
		this.listProductsView.listProductList(this.shoppingCartList);
		int input = this.customerBrowseView.getInputFromUser();
		implementUserSelection(session, input);
		return true;
	}
	
	//saves products on cart
	public void saveProductToCart(Session session) {
		int[] productInfo = this.customerBrowseView.getProductInfo();
		boolean result = this.frontController.saveProductToCart(session, productInfo);
		if(result) {
			boolean isCartFilled = viewShoppingCartProducts(session);
			if(!isCartFilled)
				browseProducts(session);
		}
		else {
			System.out.println("========!!!Invalid values entered, please check the id or quantity!!!=======");
			browseProducts(session);
		}	
	}
	
	//purchase items in cart
	public boolean purchaseItems(Session session) {
		this.shoppingCartList = this.frontController.viewShoppingCartProducts(session);
		if(this.shoppingCartList.isEmpty()) {
			System.out.println("Your Cart is empty!");
			return false;
		}
		boolean purchaseResult = this.frontController.purchaseItems(session);
		if(purchaseResult) {
			System.out.println("=======Your shopping cart Items have been purchased=========");
			return true;
		}else {
			System.out.println("========Purchasing attempt failed...Probably you were trying to buy an out of stock item=====");
			return false;
		}
		
	}
	
}