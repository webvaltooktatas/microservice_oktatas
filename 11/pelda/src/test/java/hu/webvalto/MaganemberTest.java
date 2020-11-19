package hu.webvalto;

import hu.webvalto.domain.Maganember;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class MaganemberTest {

    @Test
    public void maganembernekVanNeve(){
        Maganember maganember = new Maganember("Kristof", "1234");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        assertEquals(0,validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve4nelhosszabb(){
        Maganember maganember = new Maganember("Kristof", "1234");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        assertEquals(0,validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve4nelrovidebb(){
        Maganember maganember = new Maganember("A", "1234");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Maganember>> violations = validator.validate(maganember);
    }

    @Test
    public void maganembernekNincsNeve(){
        Maganember maganember = new Maganember(null, "1234");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        assertEquals(1,validator.validate(maganember).size());
    }
}
