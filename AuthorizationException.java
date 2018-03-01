import java.lang.RuntimeException;

public class AuthorizationException extends RuntimeException{
	public AuthorizationException(String methodName) {
		super("Invalid Authorization Exception! - Access denied to "+ methodName+"(). Bad or invalid credentails! ");
	}
}
