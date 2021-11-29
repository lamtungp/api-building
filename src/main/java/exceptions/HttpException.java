package exceptions;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	final HttpStatus status;
	final int statusCode;
	
	public HttpException(HttpStatus status) {
		super(status.name());
		this.status = status;
		this.statusCode = status.value();
	}
	
	public HttpException(HttpStatus status, String message) {
        super("Http error code " + status.value() + ". Cause: " + message);
        this.status = status;
        this.statusCode = status.value();
    }
}