package exception;

public class InvalidMoveException extends Exception {
	private static final long serialVersionUID = 4273009370055296174L;
	InvalidMoveException(String msg) {
		super(msg);
	}
}
