package hu.webvalto.masodik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate httpBasicRestTemplate;

    @GetMapping("/")
    public Object index() {
        return restTemplate.getForObject("http://localhost:8081", Object.class);
    }

    @GetMapping("/info")
    public Object info() {
        return httpBasicRestTemplate.getForObject("http://localhost:8081/actuator", Object.class);
    }

    @GetMapping("/info/{aloldal}")
    public Object infoReszletek(@PathVariable("aloldal") String aloldal) {
        return httpBasicRestTemplate.getForObject("http://localhost:8081/actuator/" + aloldal, Object.class);
    }
}
