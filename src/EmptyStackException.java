/**
 *  @author Brendan Bain 251086487
 * 
 *  Represents the situation where there is an empty stack and the user has tried to pop or peek
 */

public class EmptyStackException extends RuntimeException {
	
	public EmptyStackException(String message) {
		super(message);
	}

}
