package hu.webvalto.controller;

import hu.webvalto.service.AdobevallasRiport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdobevallasController {

    private AdobevallasRiport adobevallasRiport;

    @Autowired
    public AdobevallasController(AdobevallasRiport adobevallasRiport) {
        this.adobevallasRiport = adobevallasRiport;
    }

    @RequestMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String udvozles() {
        return "<p>Hello, adobevallasi rendszer v0.1 vagyok.</p>";
    }

    @RequestMapping("/maganszemelyek")
    public String maganszemelyek() {
        return adobevallasRiport.lekerdezesMaganszemelyek();
    }

    @RequestMapping("/cegek")
    public String cegek() {
        return adobevallasRiport.lekerdezesCegek();
    }

}