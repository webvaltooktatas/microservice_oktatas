package hu.webvalto.service;

import hu.webvalto.domain.Maganember;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AdobevallasTests {

    @Test
    public void testBefizetendoAdoHaNincsAdozo() {
        Adobevallas adobevallas = new Adobevallas();
        assertThrows(IllegalArgumentException.class, () -> {
            adobevallas.befizetendoAdo(null);
        });
    }

    @Test
    public void testBefizetendoAdoHaNemVoltBevetel() {
        Adobevallas adobevallas = new Adobevallas();
        Maganember maganember = new Maganember("Kiss Pista", "123456");

        assertEquals(0, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void testBefizetendoAdoHaNemVoltKiadas() {
        Adobevallas adobevallas = new Adobevallas();
        Maganember maganember = new Maganember("Kiss Pista", "123456");
        maganember.setEvesBevetel(100l);
        maganember.setAdokulcs(0.27);
        assertEquals(27, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void testBefizetendoAdoHaVoltKiadas() {
        Adobevallas adobevallas = new Adobevallas();
        Maganember maganember = new Maganember("Kiss Pista", "123456");
        maganember.setEvesBevetel(127l);
        maganember.setAdokulcs(0.27);
        maganember.setEvesKiadas(27l);
        assertEquals(27, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void testBefizetendoAdoHaTobbKiadasMintBevetel() {
        Adobevallas adobevallas = new Adobevallas();
        Maganember maganember = new Maganember("Kiss Pista", "123456");
        maganember.setEvesBevetel(27l);
        maganember.setAdokulcs(0.27);
        maganember.setEvesKiadas(28l);
        assertEquals(0, adobevallas.befizetendoAdo(maganember));
    }
}
