package hu.webvalto;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CegTest {

    private Validator validator;
    private Maganember maganember;
    private Cim cim;

    @BeforeEach
    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        maganember = new Maganember();
        maganember.setNev("Adam");
        maganember.setAdoszam("12345678");

        cim = new Cim();
        cim.setVaros("Budapest");
        cim.setUtca("Kossuth");
        cim.setHazszam("37");
        cim.setIranyitoszam("1212");
    }

    @Test
    public void cegnekVanNeve() {
        Ceg ceg = new Ceg("Kristof", cim, "12345678", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNeve4nelhosszabb() {
        Ceg ceg = new Ceg("Kristof", cim, "12345678", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNeve4nelrovidebb() {
        Ceg ceg = new Ceg("Bea", cim, "12345678", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNeve4karakter() {
        Ceg ceg = new Ceg("Adam", cim, "12345678", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNincsNeve() {
        Ceg ceg = new Ceg(null, cim, "12345678", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNeve10karakter() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "12345678", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNincsCim() {
        Ceg ceg = new Ceg("Kovacs Bea", null, "12345678", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNincsTulaj() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "12345678", null);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegnekNeve10nelTobbkarakter() {
        Ceg ceg = new Ceg("Kovacs Adam", cim, "12345678", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegAdoszamNincs() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, null, maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegAdoszam8nalrovidebb() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "1234567", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }

    @Test
    public void cegAdoszam8karakter() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "12345678", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegAdoszam11karakter() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "12345678901", maganember);
        assertEquals(0, validator.validate(ceg).size());
    }

    @Test
    public void cegAdoszam11nelTobbkarakter() {
        Ceg ceg = new Ceg("Kovacs Bea", cim, "123456789012", maganember);
        assertEquals(1, validator.validate(ceg).size());
    }
}
