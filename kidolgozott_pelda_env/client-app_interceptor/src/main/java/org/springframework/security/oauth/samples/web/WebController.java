package org.springframework.security.oauth.samples.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

	@Value("${resource-server.base-uri}")
	private String messagesBaseUri;

	@Autowired
	private RestTemplate restTemplate;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "{uri}")
    public String client_credentials_grant(Model model, @PathVariable("uri") String uri) {
        String eredmeny = retrieveMessages(uri);
        model.addAttribute("eredmeny", eredmeny);
        return "index";
    }

    private String retrieveMessages(String uri) {
        return restTemplate.getForObject(this.messagesBaseUri + uri, String.class);
    }
}