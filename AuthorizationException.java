import java.lang.RuntimeException;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Custom exception when for RBAC
public class AuthorizationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AuthorizationException(String methodName) {
		super("Invalid Authorization Exception! - Access denied to "+ methodName+"(). Bad or invalid credentails! ");
	}
}
