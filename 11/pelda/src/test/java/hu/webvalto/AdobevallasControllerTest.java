package hu.webvalto;

import hu.webvalto.domain.Maganember;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdobevallasControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void maganszemelyLekerdezes(){
        ResponseEntity<Maganember> response = testRestTemplate.getForEntity("http://localhost:"+port+"/maganszemely/1", Maganember.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sanyi", response.getBody().getNev());
    }

    @Test
    public void meghivunkNemLetezoMetodust(){
        ResponseEntity<Maganember> response = testRestTemplate.postForEntity("http://localhost:"+port+"/maganszemely/1",null, Maganember.class);

    }
}
