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
					rs = stmt.executeQuery( "SELECT * FROM MarketPlaceDB");
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
							productItem.setPrice(rs.getInt("price"));
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

	public void addProducts(Connection conn, List<Item> catalog){
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
						stmt.executeUpdate("INSERT INTO MarketPlaceDB (`name`,`description`,`quantity`,`price`) "
								+ "VALUES ('"+item.getName()+"','"+item.getDescription()+"','"+item.getQuantity()+"','"+item.getPrice()+"')");
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
						stmt.executeUpdate("UPDATE `MarketPlaceDB` SET `name`='"+item.getName()+"',`quantity`='"+item.getQuantity()+"',"
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
						stmt.executeUpdate("DELETE FROM MarketPlaceDB WHERE id='"+it.next()+"'");
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
	
	public String[] getUser(Connection conn, String username, String password){
		String[] user = new String[3];
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 
				try 
				{
					rs = stmt.executeQuery( "SELECT username, roleType, isAuthenticated FROM Users "
							+ "where `username`='"+username+"' and `password`='"+password+"'" );
					if (!rs.isBeforeFirst() ) {    
						user = null; 
					} 
					else{
						while (rs.next())  
						{
							user[0] = rs.getString("username");
							user[1] = rs.getString("roleType");
							user[2] = String.valueOf(rs.getBoolean("isAuthenticated"));
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
	
	public void addUsers(Connection conn, List<User> addUserList){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<User> it = addUserList.iterator();
					while(it.hasNext())
					{
						User user = (User) it.next();
						stmt.executeUpdate("INSERT INTO Users (`username`,`password`,`roleType`,`isAuthenticated`) "
								+ "VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getRoleType()+"','"+user.isAuthenticated()+"')");
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
						stmt.executeUpdate("DELETE FROM Users WHERE username='"+username+"' AND roleType='customer'");
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