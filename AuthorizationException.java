import java.lang.RuntimeException;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class AuthorizationException extends RuntimeException{
	public AuthorizationException(String methodName) {
		super("Invalid Authorization Exception! - Access denied to "+ methodName+"(). Bad or invalid credentails! ");
	}
}
