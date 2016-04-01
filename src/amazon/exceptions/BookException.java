package amazon.exceptions;

public class BookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3155823507989449434L;

	public BookException() {

	}

	public BookException(String arg0) {
		super(arg0);
	
	}

	public BookException(Throwable arg0) {
		super(arg0);
		
	}

	public BookException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public BookException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
