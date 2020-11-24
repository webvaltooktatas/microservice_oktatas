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

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void indexTest() {
        assertEquals("fooldal elerheto", "fooldal", testRestTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }

    @Test
    public void testTest() {
        assertEquals("test elerheto", "test", testRestTemplate.getForObject("http://localhost:" + port + "/test", String.class));
    }

}
