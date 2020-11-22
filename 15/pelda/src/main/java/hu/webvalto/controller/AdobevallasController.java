package hu.webvalto.controller;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import hu.webvalto.repository.CegRepository;
import hu.webvalto.repository.MaganemberRepository;
import org.slf4j.Logger;
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
import java.util.Optional;

@RestController
@Validated
public class AdobevallasController {

    private MaganemberRepository maganemberRepository;
    private CegRepository cegRepository;

    @Autowired
    private Logger logger;

    @Autowired
    public AdobevallasController(MaganemberRepository maganemberRepository, CegRepository cegRepository) {
        this.maganemberRepository = maganemberRepository;
        this.cegRepository = cegRepository;
    }

    @RequestMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String udvozles() {
        return "<p>Hello, adobevallasi rendszer v0.1 vagyok.</p>";
    }

    @PostMapping(value = "/maganember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberLetrehozas(@Valid @RequestBody Maganember maganember) {
        maganemberRepository.save(maganember);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/maganember/{id}")
    public ResponseEntity<Maganember> maganemberLekerdezes(@PathVariable @Positive Long id) {
        Optional<Maganember> maganember = maganemberRepository.findById(id);
        if (!maganember.isPresent()) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maganember.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/maganember/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberModositas(@PathVariable @Positive Long id, @RequestBody Maganember maganember) {
        boolean letezik = maganemberRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        maganemberRepository.save(maganember);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/maganember/{id}")
    public ResponseEntity<Maganember> maganemberTorlese(@PathVariable @Positive Long id) {
        boolean letezik = maganemberRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        maganemberRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/ceg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegLetrehozas(@Valid @RequestBody Ceg ceg) {
        cegRepository.save(ceg);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/ceg/{id}")
    public ResponseEntity<Ceg> cegLekerdezes(@PathVariable @Positive Long id) {
        Optional<Ceg> ceg = cegRepository.findById(id);
        if (!ceg.isPresent()) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ceg.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/ceg/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegModositas(@PathVariable @Positive Long id, @RequestBody Ceg ceg) {
        boolean letezik = cegRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cegRepository.save(ceg);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/ceg/{id}")
    public ResponseEntity<Ceg> cegTorlese(@PathVariable @Positive Long id) {
        boolean letezik = cegRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cegRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public void errorHandling() {
        logger.error("Validacios hiba tortent");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}