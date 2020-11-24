package hu.webvalto.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/")
    public String index() {
        return "fooldal";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/email")
    public void ujEmail(@RequestBody Email email) {
        emailRepository.save(email);
    }

    @GetMapping("/email")
    public List<Email> emailList() {
        return emailRepository.findAll();
    }
}
