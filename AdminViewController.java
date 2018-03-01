import java.util.List;

public class AdminViewController {
	private FrontController frontController;
	private GetAdminBrowseView getAdminBrowseView;
	//default constructor
	public AdminViewController(){
		this.frontController = new FrontController();
		this.getAdminBrowseView = new GetAdminBrowseView();
	}
	
	
	public void browseProducts(Session session) {
		List<Item> productList = this.frontController.browseProducts(session);
		BrowseProducts browseProducts = new BrowseProducts();
		browseProducts.listProductList(productList);
		int input = this.getAdminBrowseView.getInputFromUser();
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
		Item item = this.getAdminBrowseView.getProduct();
		frontController.updateProduct(session, item);
		System.out.println("\nUpdate Successful...\n");
		browseProducts(session);
	}

}
