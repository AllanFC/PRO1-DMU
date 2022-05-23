package exceptions;

public class MyFormatException extends RuntimeException {

	public MyFormatException() {
		super();
	}

	public MyFormatException(String message) {
		super(message);
	}

	public MyFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}
