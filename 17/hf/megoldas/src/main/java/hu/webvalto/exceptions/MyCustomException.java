package hu.webvalto.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Minden esetben amikor ez a hiba kerul eldobasra, az alabbi HTTP statuszkoddal fogunk visszaterni
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyCustomException extends RuntimeException {
    public MyCustomException(String message) {
        super(message);
    }
}
