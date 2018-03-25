
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<Integer, Item> productMap;
	private Map<Integer, Item> shoppingCartMap;
	private List<Item> productList;
	private List<Item> shoppingCartList;
	private static final long serialVersionUID = 1L;

	//Default Constructor
    public MarketModel() {
    	this.productMap = new HashMap<>();
    	this.shoppingCartMap = new HashMap<>();
    	this.productList = new ArrayList<>();
    	this.shoppingCartList = new ArrayList<>();
    	createItems();
    }
    
    public Session execute(Command command) {
    	return command.execute();
    }
    
    //method to browse products
    public List<Item> browseProducts(){
    	this.productList.clear();
    	for(Item item: this.productMap.values())
    		this.productList.add(item);
    	return productList;
    }
    
    //send the shopping cart list
    public List<Item> viewShoppingCartProducts() {
    	this.shoppingCartList.clear();
    	for(Item item: this.shoppingCartMap.values()) {
    		this.shoppingCartList.add(item);
    	}
		return shoppingCartList;
	}
    
    //update products
    public void updateProduct(Item item) {
    	try {
    		if(item.getId() > this.productMap.size() || item.getId()<1) {
        		throw new IndexOutOfBoundsException();
        	}
        	this.productMap.remove(item.getId());
        	this.productMap.put(item.getId(), item);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    //add to cart
    public boolean saveProductToCart(int[] productInfo) {
    	if(productInfo[0] < 1 || productInfo[0] > this.productMap.size() || !isNumeric(this.productMap.get(productInfo[0]).getQuantity()) || Integer.parseInt(this.productMap.get(productInfo[0]).getQuantity()) < productInfo[1])
    		return false;
    	if(this.shoppingCartMap.containsKey(productInfo[0])) {
    		this.shoppingCartMap.get(productInfo[0]).setQuantity(Integer.toString(productInfo[1]));
    	}else {
    		Item item = this.productMap.get(productInfo[0]);
    		Item shoppingCartItem = new Item(item.getId(), item.getName(), item.getDescription(), Integer.toString(productInfo[1]), item.getPrice());
    		this.shoppingCartMap.put(productInfo[0], shoppingCartItem);
    	}
		return true;
	}
    
    //purchase items from shopping cart
  	public boolean purchaseItems() {
  		if(this.shoppingCartMap.isEmpty())
  			return false;
  		for(Item shoppingCartItem: this.shoppingCartMap.values()) {
  			Item productListItem = this.productMap.get(shoppingCartItem.getId());
  			if(isNumeric(productListItem.getQuantity())) {
  				int stock = Integer.parseInt(productListItem.getQuantity()) - Integer.parseInt(shoppingCartItem.getQuantity());
  	  			if(stock <= 0) {
  	  				productListItem.setQuantity("Out of Stock!!! Will be back shortly (you cannot buy this right now!)");
  	  			}else {
  	  				productListItem.setQuantity(Integer.toString(stock));
  	  			}
  			}else {
  				return false;
  			}
  		}
  		this.shoppingCartMap.clear();
  		return true;
  	}
    
    
    
    //create products until database connected
    private void createItems(){
    	Item item1 = new Item(1,"Dell Laptop", "Laptop for your life", "5", 500.50f);
    	this.productMap.put(1,item1);
    	Item item2 = new Item(2,"VR Laptop", "Laptop to turn everything real", "7", 700.00f);
    	this.productMap.put(2, item2);
    	Item item3 = new Item(3,"AR Laptop", "Laptop for the next generation", "9", 750.00f);
    	this.productMap.put(3, item3);
    }
    
    //check if string is numeric value for quantity validation
    private boolean isNumeric(String s) {
    	return s != null && s.matches("[0-9]+");
    }

}