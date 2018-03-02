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
			updateProduct(session);
			break;
		case 2:
			break;
		default:
			System.out.println("Exiting system....");
			System.exit(0);
		}
	}
	
	public void updateProduct(Session session) {
		Item item = this.adminBrowseView.getProduct();
		frontController.updateProduct(session, item);
		System.out.println("\nUpdate Successful...\n");
		browseProducts(session);
	}
}
