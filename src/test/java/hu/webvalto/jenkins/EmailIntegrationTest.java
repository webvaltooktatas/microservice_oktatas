package hu.webvalto.jenkins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmailIntegrationTest {

    @Autowired
    private EmailRepository emailRepository;

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        testRestTemplate = new TestRestTemplate();
        emailRepository.deleteAll();
    }

    @Test
    public void indexTest() {
        assertEquals("fooldal elerheto", "fooldal", testRestTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }

    @Test
    public void testTest() {
        assertEquals("test elerheto", "test", testRestTemplate.getForObject("http://localhost:" + port + "/test", String.class));
    }

    @Test
    public void emailTest() {
        assertEquals("email elerheto", "[]", testRestTemplate.getForObject("http://localhost:" + port + "/email", String.class));
    }

    @Test
    public void emailPostTest() {
        testRestTemplate.postForObject("http://localhost:" + port + "/email", new Email("info@webvalto.hu", "adam.saghy@webvalto.hu", "hello"), Email.class);
        assertNotEquals("email elerheto", "[]", testRestTemplate.getForObject("http://localhost:" + port + "/email", String.class));
    }
}
