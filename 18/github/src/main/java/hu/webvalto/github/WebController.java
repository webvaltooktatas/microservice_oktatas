package hu.webvalto.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private Github github;


    @Autowired
    public WebController(Github github) {
        this.github = github;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("info", github.getInfo());
        return "home";
    }
}
