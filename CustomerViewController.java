import java.util.List;
import java.util.Scanner;

public class CustomerViewController{
	private FrontController frontController;
	//default constructor
	public CustomerViewController() {
		this.frontController = new FrontController();
	}
	
	public void browseProducts(Session session) {

		List<Item> productList = this.frontController.browseProducts(session);
		BrowseProducts browseProducts = new BrowseProducts();
		browseProducts.listProductList(productList);
		getInputFromUser();
	}
	
	public void getInputFromUser() {
		System.out.println("Please make your selection:");
		System.out.println("1. Add an item to cart");
		System.out.println("2. Purchase items in cart");
		System.out.println("3. Exit");
		Scanner scanner = new Scanner(System.in);
		System.exit(0);
	}
	
}