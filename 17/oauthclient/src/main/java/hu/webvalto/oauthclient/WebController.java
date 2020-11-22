package hu.webvalto.oauthclient;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/securedPage")
    public String securedPage() {
        return "securedPage";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
