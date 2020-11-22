package hu.webvalto.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Globalisan az alabbi hiba eldobasahoz rendel egyedi hibakezelest
@ControllerAdvice
public class MyCustomExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {MyCustomException.class})
    protected ResponseEntity<Object> handleConflict(MyCustomException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED, request);
    }
}
