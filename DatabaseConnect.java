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
							productItem.setQuantity(Integer.toString(rs.getInt("quantity"))); 
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

	public void writeProducts(Connection conn, List<Item> catalog){
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

	public void removeProducts(Connection conn, List<Item> catalog){
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
						stmt.executeUpdate("DELETE FROM MarketPlaceDB WHERE id='"+item.getId()+"'");
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