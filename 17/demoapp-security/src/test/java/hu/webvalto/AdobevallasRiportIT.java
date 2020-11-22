package hu.webvalto;

import hu.webvalto.service.AdobevallasRiport;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdobevallasRiportIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AdobevallasRiport adobevallasRiport;

    @Test
    public void lekerdezesMaganszemelyek() {
        assertEquals("Kiss Lajos maganember befizetett: 38934.0 FtNagy Marta maganember befizetett: 0.0 Ft", testRestTemplate.getForObject("http://localhost:" + port + "/maganszemelyek", String.class));
    }

    @Test
    public void lekerdezesCegek() {
        assertEquals("Good Trade ceg befizetett: 0.0 FtUjfalui Dohanybolt ceg befizetett: 1172500.0 Ft", testRestTemplate.getForObject("http://localhost:" + port + "/cegek", String.class));
    }

    @Test
    public void fooldal() {
        assertEquals("Hello, adobevallasi rendszer v0.1 vagyok.", testRestTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }
}
