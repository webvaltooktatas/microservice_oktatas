package hu.webvalto.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
