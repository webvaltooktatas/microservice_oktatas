package hu.webvalto.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String index() {
        return "fooldal";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }


}
