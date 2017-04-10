package br.com.rogrs.exception;


public class TodoNotFoundException extends Exception {


	private static final long serialVersionUID = 6769330225731576889L;

	public TodoNotFoundException(String message) {
        super(message);
    }

}
