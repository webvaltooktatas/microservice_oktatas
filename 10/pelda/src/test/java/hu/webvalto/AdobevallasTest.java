package hu.webvalto;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import hu.webvalto.service.Adobevallas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class AdobevallasTest {
    private Adobevallas adobevallas;
    private Maganember maganember;
    private Ceg ceg;

    @BeforeEach
    public void init() {
        adobevallas = new Adobevallas();
        maganember = new Maganember("Kiss Pista", "1234567890");
        maganember.setAdokulcs(0.27);

        ceg = new Ceg("Jo ceg", new Cim("Budapest", "Kossuth", "11", "1111"), "987654321", maganember);
        ceg.setAdokulcs(0.35);
    }

    @Test
    public void befizetendoAdoAdozoNelkul() {
        assertThrows(IllegalArgumentException.class, () -> {
            adobevallas.befizetendoAdo(null);
        });
    }

    @Test
    public void befizetendoAdoMaganEmberEvesBevetelNelkul() {
        assertEquals(0L, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void befizetendoAdoMaganEmberEvesBevetele0KiadasNelkul() {
        maganember.setEvesBevetel(0L);
        assertEquals(0L, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void befizetendoAdoMaganemberEvesBevetele100KiadasNelkul() {
        maganember.setEvesBevetel(100L);
        assertEquals(27L, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void befizetendoAdoMaganemberEvesBevetele110Kiadas10() {
        maganember.setEvesBevetel(110L);
        maganember.setEvesKiadas(10L);
        assertEquals(27L, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void befizetendoAdoMaganemberEvesBevetele10Kiadas20() {
        maganember.setEvesBevetel(10L);
        maganember.setEvesKiadas(20L);
        assertEquals(0L, adobevallas.befizetendoAdo(maganember));
    }

    @Test
    public void befizetendoAdoCegEvesBevetelNelkul() {
        assertEquals(0L, adobevallas.befizetendoAdo(ceg));
    }

    @Test
    public void befizetendoAdoCegEvesBevetele0KiadasNelkul() {
        ceg.setEvesBevetel(0L);
        assertEquals(0L, adobevallas.befizetendoAdo(ceg));
    }

    @Test
    public void befizetendoAdoCegEvesBevetele100KiadasNelkul() {
        ceg.setEvesBevetel(100L);
        assertEquals(35L, adobevallas.befizetendoAdo(ceg));
    }

    @Test
    public void befizetendoAdoCegEvesBevetele110Kiadas10() {
        ceg.setEvesBevetel(110L);
        ceg.setEvesKiadas(10L);
        assertEquals(35L, adobevallas.befizetendoAdo(ceg));
    }

    @Test
    public void befizetendoAdoCegEvesBevetele10Kiadas20() {
        ceg.setEvesBevetel(10L);
        ceg.setEvesKiadas(20L);
        assertEquals(0L, adobevallas.befizetendoAdo(ceg));
    }
}
