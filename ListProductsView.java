import java.util.Iterator;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class ListProductsView{
	
	
	//default constructor
	public ListProductsView() {
		
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