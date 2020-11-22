package hu.webvalto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

   // @ExceptionHandler(value = {MyCustomException.class})
    protected ResponseEntity<String> handle(MyCustomException ex, WebRequest request) {
        String body = "NEM SIKERULT";
        return new ResponseEntity<>(body, null, HttpStatus.CONFLICT);
    }
}
