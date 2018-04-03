import java.io.Serializable;

// Ryan: Are you using all classes in the util package, if not please only include those you are.
// Fixed: Removed util, not being used

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi



//Does nothing, For use in later assignments
public class Item implements Serializable{
	
    private int id;
    private String name, description;
    private float price;
    private int quantity;
    
    //Default Constructor
    public Item() {
    }
    
    //constructor to initialize values
    public Item(int id, String name, String description, int quantity, float price) {
    	this.id = id;
    	this.name = name;
    	this.description = description;
    	this.quantity = quantity;
    	this.price = price;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}