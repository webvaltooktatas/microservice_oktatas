package hu.webvalto;

import hu.webvalto.domain.Maganember;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import static org.springframework.test.util.AssertionErrors.assertNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdobevallasControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void maganszemelyLekerdezes() {
        ResponseEntity<Maganember> response = testRestTemplate.getForEntity("http://localhost:" + port + "/maganember/1", Maganember.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sanyi", response.getBody().getNev());
    }

    @Test
    public void meghivunkNemLetezoMetodust() {
        ResponseEntity<Maganember> response = testRestTemplate.postForEntity("http://localhost:" + port + "/maganember/1", null, Maganember.class);
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
    }

    @Test
    public void ujMaganEmberFelvetel() {
        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:" + port + "/maganember", new Maganember("Sanyi", "12345678"), String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Letrehozva", response.getBody());
        assertEquals(MediaType.parseMediaType("text/plain;charset=UTF-8"), response.getHeaders().getContentType());
    }

    @Test
    public void ujMaganEmberFelvetelHibas() throws JSONException {
        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:" + port + "/maganember", new Maganember("A", "12345678"), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONObject jsonObject = new JSONObject(response.getBody());
        assertEquals("igen", jsonObject.getString("validacios hiba"));
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberLekerdezes() {
        ujMaganEmberFelvetel();
        ResponseEntity<Maganember> response = testRestTemplate.getForEntity("http://localhost:" + port + "/maganember/1", Maganember.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new Maganember("Sanyi", "12345678"), response.getBody());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberHibas() throws JSONException {
        ResponseEntity<Maganember> response = testRestTemplate.getForEntity("http://localhost:" + port + "/maganember/0", Maganember.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberNemLetezik() throws JSONException {
        ResponseEntity<Maganember> response = testRestTemplate.getForEntity("http://localhost:" + port + "/maganember/999", Maganember.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberModositas() {
        ujMaganEmberFelvetel();
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/1", HttpMethod.PUT, new HttpEntity<>(new Maganember("Adamka", "456789885")), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Modositva", response.getBody());
        assertEquals(MediaType.parseMediaType("text/plain;charset=UTF-8"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberModositasHibas() throws JSONException {
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/0", HttpMethod.PUT, new HttpEntity<>(new Maganember("Adamka", "456789885")), String.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberModositasNemLetezik() throws JSONException {
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/999", HttpMethod.PUT, new HttpEntity<>(new Maganember("Adamka", "456789885")), String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberTorles() {
        ujMaganEmberFelvetel();
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/1", HttpMethod.DELETE,null, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(null, response.getBody());
        assertNull(null, response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberTorlesHibas() throws JSONException {
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/0", HttpMethod.DELETE,null, String.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    @Test
    public void maganEmberTorlesNemLetezik() throws JSONException {
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/maganember/999", HttpMethod.DELETE,null, String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(MediaType.parseMediaType("application/json"), response.getHeaders().getContentType());
    }

    //INFO: Cegek integracios tesztje, hasonloan vegezheto
}
