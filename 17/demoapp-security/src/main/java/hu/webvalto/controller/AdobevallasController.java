package hu.webvalto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AdobevallasController {

    @RequestMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String udvozles() {
        return "<p>Hello, adobevallasi rendszer v0.1 vagyok.</p>";
    }

}