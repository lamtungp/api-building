package exceptions;
import org.springframework.http.HttpStatus;

public class BadRequestHttpException extends HttpException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestHttpException() {
		super(HttpStatus.BAD_REQUEST);
	}
	
	public BadRequestHttpException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}