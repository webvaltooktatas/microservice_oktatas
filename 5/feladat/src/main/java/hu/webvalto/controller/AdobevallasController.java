package hu.webvalto.controller;

import hu.webvalto.service.Adobevallas;
import hu.webvalto.service.AdobevallasRiport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdobevallasController {

    @Autowired
    private AdobevallasRiport adobevallasRiport;

    @RequestMapping("/")
    public String index() {
        return adobevallasRiport.lekerdezes();
    }
}
