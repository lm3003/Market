
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Ryan: Are you using all classes in the util package, if not please only include those you are.
// Fixed: Fixed as requested

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


// Ryan: Shouldn't the Model be doing something here?

// Fixed: For the first assignment, Model only was a part of the skeleton framework that we created according to the requirements.
// Now it helps in credential verification by acting as an invoker

//Acts as an invoker for command pattern
public class MarketModel implements Serializable{
	private List<Item> productList;
	private List<Item> shoppingCartList;
   
	private static final long serialVersionUID = 1L;

	//Default Constructor
    public MarketModel() {
    	this.productList = createItems();
    	this.shoppingCartList = new ArrayList<>();
    }
    
    public Session execute(Command command) {
    	return command.execute();
    }
    
    //method to browse products
    public List<Item> browseProducts(){
    	return this.productList;
    }
    
    //send the shopping cart list
    public List<Item> viewShoppingCartProducts(Session session) {
		return this.shoppingCartList;
	}
    
    //update products
    public void updateProduct(Item item) {
    	try {
    		if(item.getId()>this.productList.size()||item.getId()<1) {
        		throw new IndexOutOfBoundsException();
        	}
        	this.productList.remove(item.getId()-1);
        	this.productList.add(item.getId()-1, item);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    //add to cart
    public void saveProductToCart(int productId) {
		this.shoppingCartList.add(this.productList.get(productId-1));
	}
    
    
    
    //create products until database connected
    private List<Item> createItems(){
    	this.productList = new ArrayList<Item>();
    	Item item1 = new Item(1,"Dell Laptop", "Laptop for your life", 5, 500.50f);
    	Item item2 = new Item(2,"VR Laptop", "Laptop to turn everything real", 7, 700.00f);
    	Item item3 = new Item(3,"AR Laptop", "Laptop for the next generation", 9, 750.00f);
    	productList.add(item1);
    	productList.add(item2);
    	productList.add(item3);
    	return productList;
    }

}