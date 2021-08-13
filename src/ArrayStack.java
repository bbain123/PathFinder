import java.util.*;

/**
 * Represents a stack made of an array
 * @author Brendan Bain 251086487
 * @param <T> The generic type of the array stack
 */


public class ArrayStack<T> implements ArrayStackADT<T> {
	
	private T[] stack;
	private int top, initialCapacity, sizeIncrease, sizeDecrease;
	
	/**
	 * Constructor for ArrayStack
	 * @param initialCap the initial capacity of the arraystack
	 * @param sizeInc the amount the array stack increases if its at max capacity 
	 * @param sizeDec the amount the array stack decreases 
	 */
	public ArrayStack (int initialCap, int sizeInc, int sizeDec) {
		top = 0;
		initialCapacity = initialCap;
		sizeIncrease = sizeInc;
		sizeDecrease = sizeDec;
		stack = (T[]) (new Object[initialCapacity]);
	}
	
	
	/**
	 * adds an item to the top of the stack
	 * @param dataItem the item being pushed into the stack
	 */
	public void push(T dataItem) {
		if (stack.length == top) {
			T[] tempArray = (T[])(new Object[stack.length]);
			for (int i = 0; i < stack.length; i++) 
				tempArray[i] = stack[i]; 
	
			stack = (T[]) (new Object[tempArray.length + sizeIncrease]);
			for (int i = 0; i < tempArray.length; i++) 
				stack[i] = tempArray[i]; 
		}
		
		stack[top] = dataItem;
		top++;
			
	}
	
	/**
	 * removes the item on the top of the stack
	 * @return the item on top of the stack
	 */
	public T pop() throws EmptyStackException {
		if ((top-1) < 0)
			throw new EmptyStackException("Cannot peak; the stack is empty");
		
		if ((top-1) < (stack.length/4) & stack.length > initialCapacity){
			T[] tempArray = (T[])(new Object[stack.length]);
			for (int i = 0; i < top; i++)
				tempArray[i] = stack[i];
			
			stack = (T[]) (new Object[tempArray.length - sizeDecrease]);
			for (int i = 0; i < top; i++) 
				stack[i] = tempArray[i]; 	
		}
		
		top--;
		return stack[top];
	}
	
	/**
	 * returns the item on top of the stack without removing it
	 * @return the item on top of the stack
	 */
	public T peek() throws EmptyStackException {
		if (top <= 0)
			throw new EmptyStackException("Cannot peak; the stack is empty");
		
		return stack[top-1];
		
	}
	
	/**
	 * returns true if the stack is empty
	 */
	public boolean isEmpty() {
		return (top == 0);
	}
	
	/**
	 * returns the number of items in the array stack
	 * @return the number of items in the arraystack
	 */
	public int size() {
		return top;
	}
	
	/**
	 * returns the length of the array
	 * @return
	 */
	public int length() {
		return stack.length;
	}
	
	/**
	 * The string interpretation of arrayStack
	 * @return the contents of the stack from top to bottom
	 */
	public String toString() {
		String tempString = ("Stack:");
		String optionalComma = "";
		for (int i = 0; i < top; i++) {
			if (i != 0)
				optionalComma = ",";
			tempString = tempString + optionalComma + " " + stack[i]; 
		}
		return tempString;
	}


}
