import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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
	private List<Item> productList;
	private Map<Integer,Item> shoppingCartMap;
	private List<Item> shoppingCartList;
	private DatabaseConnect db;
	private static final long serialVersionUID = 1L;
	public MarketModel(){
		this.shoppingCartList = new ArrayList<>();
		this.shoppingCartMap = new HashMap<>();
		this.db = new DatabaseConnect();
	}
	
    public Session authenticate(String[] credentials) {
    	Session session = new Session();
    	if(credentials[0].equals("customer") && credentials[1].equals("customer")) { // validating customer credentials
    		session.setRoleType("Customer");
    		session.setUserName(credentials[0]);									//If auth accepted, setup valid session values
    		session.setAuthenticated(true);
    		
    	}else if(credentials[0].equals("admin") && credentials[1].equals("admin")) { // validating admin credentials
    		session.setRoleType("Admin");
    		session.setUserName(credentials[0]);									//If auth accepted, setup valid session values
    		session.setAuthenticated(true);
    	}else {
    		session.setRoleType("Invalid");
    		session.setUserName(credentials[0]);									//If auth denied, setup invalid session values
    		session.setAuthenticated(false);
    	}
    	return session;
    }
    
    //method to browse products
    public List<Item> browseProducts(){
    	try {
    		Connection conn = this.db.dbConnect();
        	this.productList = this.db.readProducts(conn);
        	conn.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return this.productList;
    }
    
    //send the shopping cart list
    public List<Item> viewShoppingCartProducts() {
    	this.shoppingCartList.clear();
    	for(Item item: this.shoppingCartMap.values()) {
    		this.shoppingCartList.add(item);
    	}
		return this.shoppingCartList;
	}
    
    //update products
    public void updateProduct(List<Item> item) {
    	
    }
    
    //add to cart
    public boolean saveProductToCart(int[] productInfo) {
    	Map<Integer,Item> productMap = new HashMap<>();
    	this.productList = browseProducts();
    	for(Item item: this.productList) {
    		productMap.put(item.getId(), item);
    	}
    	if(productInfo[0] < 1 || productInfo[0] > productMap.size() || !isNumeric(productMap.get(productInfo[0]).getQuantity()) || Integer.parseInt(productMap.get(productInfo[0]).getQuantity()) < productInfo[1])
    		return false;
    	if(this.shoppingCartMap.containsKey(productInfo[0])) {
    		this.shoppingCartMap.get(productInfo[0]).setQuantity(Integer.toString(productInfo[1]));
    	}else {
    		Item item = productMap.get(productInfo[0]);
    		Item shoppingCartItem = new Item(item.getId(), item.getName(), item.getDescription(), Integer.toString(productInfo[1]), item.getPrice());
    		this.shoppingCartMap.put(productInfo[0], shoppingCartItem);
    	}
		return true;
	}
    
    //purchase items from shopping cart
  	public boolean purchaseItems() {
  		
  		
  		Map<Integer,Item> productMap = new HashMap<>();
    	this.productList = browseProducts();
    	for(Item item: this.productList) {
    		productMap.put(item.getId(), item);
    	}
  		if(this.shoppingCartMap.isEmpty())
  			return false;
  		for(Item shoppingCartItem: this.shoppingCartMap.values()) {
  			Item productListItem = productMap.get(shoppingCartItem.getId());
  			if(isNumeric(productListItem.getQuantity())) {
  				int stock = Integer.parseInt(productListItem.getQuantity()) - Integer.parseInt(shoppingCartItem.getQuantity());
  	  			productListItem.setQuantity(Integer.toString(stock));
  			}else {
  				return false;
  			}
  		}
		try {
			Connection conn = this.db.dbConnect();
			this.db.updateProducts(conn, this.productList);
			conn.close();
		}catch(SQLException e) {
		  		e.printStackTrace();
		  	}
  		
  		this.shoppingCartMap.clear();
  		return true;
  	}
    
    //check if string is numeric value for quantity validation
    private boolean isNumeric(String s) {
    	return s != null && s.matches("[0-9]+");
    }

}