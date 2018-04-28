import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DatabaseConnect implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	//Default Constructor
	public DatabaseConnect() {
		
	}

	public Connection dbConnect () 
	{
		
		String hostname = "localhost:3306"; 
		String dbName = "lmodi_db";
		String url = "jdbc:mysql://" + hostname + "/" + dbName; 
		String username = "lmodi"; 
		String password = "lm3003";
		
		System.out.println("Connecting database..."); 
		try 
		{     
		      // Setup the connection with the DB
		      	conn = (Connection)DriverManager.getConnection(url, username, password);
				System.out.println("Database connected!");
		} 
		catch (SQLException e) 
		{     
			throw new IllegalStateException("Cannot connect the database!",e);
		}
		return conn;
	}
	
	public List<Item> readProducts(Connection conn){
		List<Item> catalog = new ArrayList <>();

		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 

				try 
				{
					rs = stmt.executeQuery( "SELECT * FROM tbl_items");
					if (!rs.isBeforeFirst()) {    
						System.out.println("No products found"); 
					} 
					else{
						while (rs.next())  
						{
							Item productItem = new Item();
							productItem.setId(rs.getInt("id"));
							productItem.setName(rs.getString("name")); 
							productItem.setDescription(rs.getString("description")); 
							productItem.setQuantity(rs.getInt("quantity")); 
							productItem.setPrice(rs.getFloat("price"));
							catalog.add(productItem);
						}
					}
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!"); 
					e.printStackTrace();
				} 
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return catalog;
	}
	
	public boolean saveProductToCart(Connection conn, String username, int[] productInfo) {
		if(conn != null) 
		{
			Statement stmt = null;
			Statement stmt2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				stmt2 = (Statement) conn.createStatement();
				try{
						rs2 = stmt2.executeQuery( "SELECT * FROM tbl_shopping_cart_items "
								+ "where `id`='"+productInfo[0]+"'" );
						if(rs2.next()) {
							System.out.println("within rs.next");
							stmt2.close();
							return false;
						}
						rs = stmt.executeQuery("Select * FROM tbl_items WHERE id ='"+productInfo[0]+"'");
						if (!rs.isBeforeFirst()) {    
							System.out.println("No products found"); 
						}else {
								rs.next();
								stmt.executeUpdate("INSERT INTO tbl_shopping_cart_items (`id`,`name`,`description`,`quantity`,`price`, `username`) "
										+ "VALUES ('"+rs.getInt("id")+"','"+rs.getString("name")+"','"+rs.getString("description")+"','"+productInfo[1]+"','"+rs.getFloat("price")+"','"+username+"')");
//								stmt.executeQuery("INSERT INTO tbl_shopping_cart_items (`id`, `name`, `description`, `quantity`, `price`)"
//										+ "VALUES ('"+rs.getInt("id")+"','"+rs.getString("name")+"','"+rs.getString("description")+"','"+rs.getInt("quantity")+"','"+rs.getFloat("price")+"')");
								stmt.executeUpdate("INSERT INTO tbl_cart (`username`,`item_id`) "
										+ "VALUES ('"+username+"','"+productInfo[0]+"')");
								return true;
						}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}
				stmt2.close();	
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}
		return false;
	}
	
	public List<Item> getShoppingCartProducts(Connection conn, String username) {
		List<Item> catalog = new ArrayList <>();
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs_tbl_cart = null, rs_tbl_items = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 

				try 
				{
					rs_tbl_cart = stmt.executeQuery( "SELECT item_id FROM tbl_cart WHERE username ='"+username+"'");
					if (!rs_tbl_cart.isBeforeFirst()) {    
						System.out.println("No products found"); 
					} 
					else{
						List<Integer> itemIdList = new ArrayList<>();
						while(rs_tbl_cart.next()) {
							itemIdList.add(rs_tbl_cart.getInt("item_id"));
						}
						Iterator<Integer> it = itemIdList.iterator();
						while(it.hasNext()) {
							rs_tbl_items = stmt.executeQuery("SELECT * FROM tbl_shopping_cart_items WHERE id ='"+it.next()+"'");
							rs_tbl_items.next();
							Item productItem = new Item();
							productItem.setId(rs_tbl_items.getInt("id"));
							productItem.setName(rs_tbl_items.getString("name")); 
							productItem.setDescription(rs_tbl_items.getString("description")); 
							productItem.setQuantity(rs_tbl_items.getInt("quantity")); 
							productItem.setPrice(rs_tbl_items.getFloat("price"));
							catalog.add(productItem);
						}		
					}
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!"); 
					e.printStackTrace();
				} 
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return catalog;
	}
	
	//method to update stock and update shopping cart table upon purchase
	public void stockUpdate(Connection conn, String username,List<Item> shoppingCartProductList) {
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				Iterator<Item> it = shoppingCartProductList.iterator();
				while(it.hasNext()) {
					Item item = it.next();
					stmt.executeUpdate( "UPDATE tbl_items SET quantity = quantity - '"+item.getQuantity()+"' WHERE id ='"+item.getId()+"'");
				}
				stmt.executeUpdate("Delete FROM tbl_cart where username ='"+username+"'");
				stmt.executeUpdate("Delete FROM tbl_shopping_cart_items WHERE username ='"+username+"'");
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
	}
	
	//get product quantity
	public int getProductQuantity(Connection conn, int itemId) {
		int quantity = 0;
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 

				try 
				{
					rs = stmt.executeQuery( "SELECT quantity FROM tbl_items WHERE id ='"+itemId+"'");
					if (!rs.isBeforeFirst()) {    
						System.out.println("No products found");
						return -1;
					} 
					else{
						rs.next();
						quantity = rs.getInt("quantity");
					}		
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!"); 
					e.printStackTrace();
				} 
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return quantity;
	}

	//add products to inventory
	public boolean addProducts(Connection conn, List<Item> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<Item> it = catalog.iterator();
					while(it.hasNext())
					{
						Item item = (Item) it.next();
						System.out.println(item.getName()+"	"+item.getDescription()+"	"+item.getQuantity()+"  "+item.getPrice());
						stmt.executeUpdate("INSERT INTO tbl_items (`name`,`description`,`quantity`,`price`) "
								+ "VALUES ('"+item.getName()+"','"+item.getDescription()+"','"+item.getQuantity()+"','"+item.getPrice()+"')");
					}
					return true;
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}
		return false;
	}

	//update products in inventory
	public void updateProducts(Connection conn, List<Item> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<Item> it = catalog.iterator();
					while(it.hasNext())
					{
						Item item= (Item) it.next();
						System.out.println(item.getName()+"	"+item.getDescription()+"	"+item.getQuantity()+"	"+item.getPrice());
						stmt.executeUpdate("UPDATE tbl_items SET `name`='"+item.getName()+"',`quantity`='"+item.getQuantity()+"',"
								+ "`price`='"+item.getPrice()+"',`description`='"+item.getDescription()+"' WHERE `id`='"+item.getId()+"'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}

	//delete products from inventory
	public void deleteProduct(Connection conn, List<Integer> deleteProductIdList){
		if(conn != null) 
		{
			Statement stmt = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<Integer> it = deleteProductIdList.iterator();
					while(it.hasNext()) {
						stmt.executeUpdate("DELETE FROM tbl_items WHERE id='"+it.next()+"'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}
	
	//get user details
	public String[] getUser(Connection conn, String username, String password){
		String[] user = new String[2];
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 
				try 
				{
					rs = stmt.executeQuery( "SELECT username, roleType FROM tbl_users "
							+ "where `username`='"+username+"' and `password`='"+password+"'" );
					if (!rs.isBeforeFirst() ) {    
						user = null; 
					} 
					else{
						while (rs.next())  
						{
							user[0] = rs.getString("username");
							user[1] = rs.getString("roleType");
						}
					}
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!");
					user = null;
					e.printStackTrace();
				} 
				stmt.close();

			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return user;
	}
	
	//add users to user table
	public boolean addUsers(Connection conn, List<User> addUserList){
		if(conn != null) 
		{
			Statement stmt = null;
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<User> it = addUserList.iterator();
					while(it.hasNext())
					{
						User user = (User) it.next();
						rs = stmt.executeQuery( "SELECT * FROM tbl_users "
								+ "where `username`='"+user.getUsername()+"'" );
						if(rs.next()) {
							System.out.println("within rs.next");
							return false;
						}
						stmt.executeUpdate("INSERT INTO tbl_users (`firstname`, `lastname`, `username`,`password`, `roleType`) "
								+ "VALUES ('"+user.getFirstname()+"','"+user.getLastname()+"','"
								+ user.getUsername()+"','"+user.getPassword()+"','"+user.getRoleType()+"')");
					}
					return true;
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}
		return false;
	}
	
	//delete users from the user table
	public void deleteUsers(Connection conn, List<User> deleteUserList){
		if(conn != null) 
		{
			Statement stmt = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<User> it = deleteUserList.iterator();
					while(it.hasNext()) {
						String username = it.next().getUsername();
						System.out.println("Delete username: "+ username);
						stmt.executeUpdate("DELETE FROM tbl_users WHERE username='"+username+"' AND roleType='customer'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}
	
}