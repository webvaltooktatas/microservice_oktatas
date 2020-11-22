package hu.webvalto.exceptions;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ValidationException;
import java.util.Map;

//Alapertelmezett Spring Boot hibauzenetkezelesenek kiterjesztese, modositasa
@Component
public class MyCustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Throwable error = getError(webRequest);
        if (error instanceof ValidationException || error instanceof MethodArgumentNotValidException) {
            errorAttributes.put("validacios hiba", "igen");
        }

        return errorAttributes;
    }
}
