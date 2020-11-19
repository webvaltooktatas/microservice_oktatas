package hu.webvalto.controller;

import hu.webvalto.domain.Maganember;
import hu.webvalto.exceptions.MyCustomException;
import hu.webvalto.service.AdobevallasRiport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

@RestController
@Validated
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

    @GetMapping(value = "/maganszemely/{id}")
    public ResponseEntity<Maganember> maganszemelyLekerdezese(@PathVariable("id") @Min(1) String id,
                                                              @RequestHeader Map<String, String> header) {
        Maganember maganember = new Maganember("Sanyi", "123456");
        return new ResponseEntity<>(maganember, HttpStatus.OK);
    }

    @PostMapping(value = "/maganszemely", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Maganember> maganSzemelyFelvetele(@Valid @RequestBody Maganember maganember) {
        maganember.getAdokulcs();
        return new ResponseEntity<>(maganember, HttpStatus.OK);
    }

    @PutMapping("/maganszemely/{id}")
    public ResponseEntity<Maganember> maganszemelyModositasa(@RequestBody Maganember maganember) {
        try {
            throw new MyCustomException("Nem talalhato a kert maganszemely");
        } catch (MyCustomException ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}