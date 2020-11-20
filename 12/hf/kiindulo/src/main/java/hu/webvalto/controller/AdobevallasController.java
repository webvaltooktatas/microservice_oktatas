package hu.webvalto.controller;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import hu.webvalto.repository.AdozoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
public class AdobevallasController {

    private AdozoRepository adozoRepository;

    @Autowired
    public AdobevallasController(AdozoRepository adozoRepository) {
        this.adozoRepository = adozoRepository;
    }

    @RequestMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String udvozles() {
        return "<p>Hello, adobevallasi rendszer v0.1 vagyok.</p>";
    }

    @PostMapping(value = "/maganember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberLetrehozas(@Valid @RequestBody Maganember maganember) {
        adozoRepository.addUjMaganember(maganember);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/maganember/{id}")
    public ResponseEntity<Maganember> maganemberLekerdezes(@PathVariable @Positive Integer id) {
        Maganember maganember = adozoRepository.getMaganemberById(id);
        if (maganember == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maganember, HttpStatus.OK);
    }

    @PutMapping(value = "/maganember/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberModositas(@PathVariable @Positive Integer id, @RequestBody Maganember maganember) {
        Maganember eredetiMaganember = adozoRepository.getMaganemberById(id);
        if (eredetiMaganember == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        adozoRepository.modifyMaganember(id, maganember);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/maganember/{id}")
    public ResponseEntity<Maganember> maganemberTorlese(@PathVariable @Positive Integer id) {
        Maganember eredetiMaganember = adozoRepository.getMaganemberById(id);
        if (eredetiMaganember == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        adozoRepository.removeMaganember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/ceg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegLetrehozas(@Valid @RequestBody Ceg ceg) {
        adozoRepository.addUjCeg(ceg);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/ceg/{id}")
    public ResponseEntity<Ceg> cegLekerdezes(@PathVariable @Positive Integer id) {
        Ceg ceg = adozoRepository.getCegById(id);
        if (ceg == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ceg, HttpStatus.OK);
    }

    @PutMapping(value = "/ceg/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegModositas(@PathVariable @Positive Integer id, @RequestBody Ceg ceg) {
        Ceg eredetiCeg = adozoRepository.getCegById(id);
        if (eredetiCeg == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        adozoRepository.modifyCeg(id, ceg);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/ceg/{id}")
    public ResponseEntity<Ceg> cegTorlese(@PathVariable @Positive Integer id) {
        adozoRepository.removeCeg(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public void errorHandling() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}