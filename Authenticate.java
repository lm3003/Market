//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


//Command for authentication
public class Authenticate implements Command{
	private User user;
	
	public Authenticate(User user) {
		this.user = user;
	}
	
	@Override
	public boolean execute() {
		return user.authenticate();	
	}

}
