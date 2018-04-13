import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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
	private DatabaseConnect db;
	private static final long serialVersionUID = 1L;
	public MarketModel(){
		this.db = new DatabaseConnect();
	}
	
	//register user
	public synchronized boolean registerUser(User newUser) {
		List<User> newUserList = new ArrayList<>();
		newUserList.add(newUser);
		try {
    		Connection conn = this.db.dbConnect();
    		this.db.addUsers(conn, newUserList);
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;
	}
	
    public synchronized Session authenticate(User registeredUser) {
    	Session session = new Session();
    	String[] user = null;
    	try {
    		Connection conn = this.db.dbConnect();
    		user = this.db.getUser(conn, registeredUser.getUsername(), registeredUser.getPassword());
    		conn.close();
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    	if(user != null) { // validating customer credentials
    		session.setUserName(user[0]);									//If auth accepted, setup valid session valuess
    		session.setRoleType(user[1]);
    		session.setAuthenticated(true);	
    	}else {
    		session.setRoleType("Invalid");
    		session.setUserName(null);									//If auth denied, setup invalid session values
    		session.setAuthenticated(false);
    	}
    	return session;
    }
    
    public boolean addUsers(List<User> addUserList) {
    	try {
    		Connection conn = this.db.dbConnect();
    		this.db.addUsers(conn, addUserList);
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;
	}

	public boolean deleteUsers(List<User> deleteUserList) {
		try {
    		Connection conn = this.db.dbConnect();
    		this.db.deleteUsers(conn, deleteUserList);
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;
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
    public List<Item> viewShoppingCartProducts(String username) {
    	List<Item> shoppingCartProductList = null;
    	try {
    		Connection conn = this.db.dbConnect();
    		shoppingCartProductList = this.db.getShoppingCartProducts(conn, username);
    		conn.close();
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return shoppingCartProductList;
	}
    
    //add new products
    public boolean addProducts(List<Item> addProductList) {
    	try {
    		Connection conn = this.db.dbConnect();
    		this.db.addProducts(conn, addProductList);
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;
    }
    
    //update products
    public boolean updateProducts(List<Item> updateProductList) {
    	try {
    		Connection conn = this.db.dbConnect();
    		this.db.updateProducts(conn, updateProductList);
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;
    }
    
    //add to cart
    public boolean saveProductToCart(String username, int[] productInfo) {
    	try {
    		Connection conn = this.db.dbConnect();
    		int quantityInStock = this.db.getProductQuantity(conn, productInfo[0]);
    		if(quantityInStock != -1 && quantityInStock - productInfo[1] >= 0) {
    			this.db.saveProductToCart(conn, username, productInfo);
    		}else {
    			conn.close();
    			return false;
    		}
    		conn.close();
    		return true;
    	}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
    	return false;

	}
    
    //purchase items from shopping cart
  	public boolean purchaseItems(String username) {
  		List<Item> shoppingCartProductList = viewShoppingCartProducts(username);
  		try {
  			Connection conn = this.db.dbConnect();
  			this.db.stockUpdate(conn, username, shoppingCartProductList);
  			conn.close();
  			return true;
  		}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
  		return false;
  	}
  	
  	//delete product
  	public boolean deleteProducts(List<Integer> deleteProductIdList) {
  		try {
  			Connection conn = this.db.dbConnect();
  			this.db.deleteProduct(conn, deleteProductIdList);
  			conn.close();
  			return true;
  		}catch(SQLException e) {
	  		e.printStackTrace();
	  	}
  		return false;
  	}
}