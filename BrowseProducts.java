import java.util.Iterator;
import java.util.List;

public class BrowseProducts{
	
	
	//default constructor
	public BrowseProducts() {
		
	}
	
	public void listProductList(List<Item> productList) {
		Iterator<Item> iterator = productList.listIterator();
		while(iterator.hasNext()) {
			Item item = (Item) iterator.next();
			System.out.println();
			System.out.println("Item Number: " + item.getId());
			System.out.println("Name: " + item.getName());
			System.out.println("Description: " + item.getDescription());
			System.out.println("Quantity in Stock: " + item.getQuantity());
			System.out.println("Price per item: " + item.getPrice());
			System.out.println();
		}
	}
}