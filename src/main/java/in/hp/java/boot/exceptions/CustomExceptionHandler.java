package in.hp.java.boot.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Custom Exception Handler
 * Used to impose org level exception standard
 *
 * @RestController - this acts as a controller as it directly sends response
 * @ControllerAdvice
 *      - the methods in the class should be common to all controllers,
 *      - hence aop kind of advice is used
 *
 * Any exceptions returned from any controller comes to this handler
 * The method is executed based on @ExceptionHandler advice
 */
@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * The below method is used to handle all the exceptions reported by controller
     * It returns back custom exception with status code 500
     * <p>
     * request.getDescription(false) - here false is passed to not reveal client info
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This method is executed for only ResourceNotFoundException
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleAllException(ResourceNotFoundException ex, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(genericException, HttpStatus.NOT_FOUND);
    }

    /**
     * Overriding method to handle MethodArgumentNotValidException
     * We can fetch the result of validation from "BindingResult"
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), "Validation failed for input.", ex.getBindingResult().toString()
        );
        return new ResponseEntity<>(genericException, status);
    }
}