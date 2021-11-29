package exceptions;
import org.springframework.http.HttpStatus;

public class InternalServerHttpException extends HttpException {

	private static final long serialVersionUID = 1L;
	
	public InternalServerHttpException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public InternalServerHttpException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}