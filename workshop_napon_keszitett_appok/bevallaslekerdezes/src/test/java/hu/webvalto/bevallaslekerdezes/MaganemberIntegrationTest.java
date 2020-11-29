package hu.webvalto.bevallaslekerdezes;

import hu.webvalto.bevallaslekerdezes.domain.Ceg;
import hu.webvalto.bevallaslekerdezes.domain.Maganember;
import hu.webvalto.bevallaslekerdezes.repository.CegRepository;
import hu.webvalto.bevallaslekerdezes.repository.MaganemberRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MaganemberIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MaganemberRepository maganemberRepository;

    @Autowired
    private CegRepository cegRepository;

    @BeforeEach
    public void init() {
        maganemberRepository.deleteAll();
        cegRepository.deleteAll();

        Maganember maganember = new Maganember();
        maganember.setAdoszam("123456789");
        maganember.setNev("Adam");
        maganemberRepository.save(maganember);

        Ceg ceg = new Ceg();
        ceg.setAdoszam("987654321");
        ceg.setNev("Dohanybolt");
        cegRepository.save(ceg);
    }

    @Test
    public void maganemberLekerdezes() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:" + port + "/maganember", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void cegLekerdezes() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:" + port + "/ceg", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
