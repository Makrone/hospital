package by.hospital.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -7434161787705766077L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
