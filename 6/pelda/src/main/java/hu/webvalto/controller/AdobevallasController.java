package hu.webvalto.controller;

import hu.webvalto.service.AdobevallasRiport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdobevallasController {

    private AdobevallasRiport adobevallasRiport;

    @Autowired
    public AdobevallasController(AdobevallasRiport adobevallasRiport) {
        this.adobevallasRiport = adobevallasRiport;
    }

    @RequestMapping("/")
    public String udvozles() {
        return "Hello, adobevallasi rendszer v0.4 vagyok.";
    }

    @RequestMapping("/lekerdezes")
    public String lekerdezes() {
        return adobevallasRiport.lekerdezes();
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
