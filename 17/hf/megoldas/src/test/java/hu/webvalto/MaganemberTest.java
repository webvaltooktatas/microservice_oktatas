package hu.webvalto;

import hu.webvalto.domain.Maganember;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MaganemberTest {

    private Validator validator;

    @BeforeEach
    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void maganembernekVanNeve() {
        Maganember maganember = new Maganember("Kristof", "12345678");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve4nelhosszabb() {
        Maganember maganember = new Maganember("Kristof", "12345678");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve4nelrovidebb() {
        Maganember maganember = new Maganember("Bea", "12345678");
        assertEquals(1, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve4karakter() {
        Maganember maganember = new Maganember("Adam", "12345678");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNincsNeve() {
        Maganember maganember = new Maganember(null, "12345678");
        assertEquals(1, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve10karakter() {
        Maganember maganember = new Maganember("Kovacs Bea", "12345678");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganembernekNeve10nelTobbkarakter() {
        Maganember maganember = new Maganember("Kovacs Adam", "12345678");
        assertEquals(1, validator.validate(maganember).size());
    }

    @Test
    public void maganemberAdoszamNincs() {
        Maganember maganember = new Maganember("Kovacs Bea", null);
        assertEquals(1, validator.validate(maganember).size());
    }

    @Test
    public void maganemberAdoszam8nalrovidebb() {
        Maganember maganember = new Maganember("Kovacs Bea", "1234567");
        assertEquals(1, validator.validate(maganember).size());
    }

    @Test
    public void maganemberAdoszam8karakter() {
        Maganember maganember = new Maganember("Kovacs Bea", "12345678");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganemberAdoszam11karakter() {
        Maganember maganember = new Maganember("Kovacs Bea", "12345678901");
        assertEquals(0, validator.validate(maganember).size());
    }

    @Test
    public void maganemberAdoszam11nelTobbkarakter() {
        Maganember maganember = new Maganember("Kovacs Bea", "123456789012");
        assertEquals(1, validator.validate(maganember).size());
    }
}
