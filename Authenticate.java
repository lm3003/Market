

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
