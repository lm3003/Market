
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
/**
 * 
 */

//Acts as an invoker for command pattern
public class MarketModel {

    /**
     * Default constructor
     */
    public MarketModel() {}
    
    public boolean execute(Command command) {
    	return command.execute();
    }
    
    /**
     * 
     */
    public void marketModel() {
        // TODO implement here
    }
    

    /**
     * 
     */
    public void getItem() {
        // TODO implement here
    }

}