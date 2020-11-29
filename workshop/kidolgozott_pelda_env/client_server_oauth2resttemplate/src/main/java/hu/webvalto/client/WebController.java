package hu.webvalto.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @GetMapping("/authorized")        // registered redirect_uri for authorization_code
    public String authorized() {
        return "index";
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        return restTemplate.getForObject("http://localhost:8092/ceg/1/nyilatkozatok", String.class);
    }
}
