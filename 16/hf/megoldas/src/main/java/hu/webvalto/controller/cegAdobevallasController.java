package hu.webvalto.controller;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Nyilatkozat;
import hu.webvalto.repository.CegRepository;
import hu.webvalto.service.AdobevallasRiport;
import hu.webvalto.service.NyilatkozatService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ceg")
public class cegAdobevallasController {
    @Autowired
    private Logger logger;
    private final CegRepository cegRepository;
    private final NyilatkozatService nyilatkozatService;
    private final AdobevallasRiport adobevallasRiport;

    @Autowired
    public cegAdobevallasController(CegRepository cegRepository, NyilatkozatService nyilatkozatService, AdobevallasRiport adobevallasRiport) {
        this.cegRepository = cegRepository;
        this.nyilatkozatService = nyilatkozatService;
        this.adobevallasRiport = adobevallasRiport;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegLetrehozas(@Valid @RequestBody Ceg ceg) {
        cegRepository.save(ceg);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ceg> cegLekerdezes(@PathVariable @Positive Long id) {
        Optional<Ceg> ceg = cegRepository.findById(id);
        if (!ceg.isPresent()) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ceg.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cegModositas(@PathVariable @Positive Long id, @RequestBody Ceg ceg) {
        boolean letezik = cegRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cegRepository.save(ceg);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Ceg> cegTorlese(@PathVariable @Positive Long id) {
        boolean letezik = cegRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cegRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/nyilatkozatok")
    public ResponseEntity<List<Nyilatkozat>> maganemberNyilatkozatok(@PathVariable @Positive Long id) {
        Optional<Ceg> ceg = cegRepository.findById(id);
        if (!ceg.isPresent()) {
            logger.error("Nem talalhato a keresett ceg");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nyilatkozatService.nyilatkozatokLekerdezese(ceg.get()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/adobevallas")
    public ResponseEntity<List<Nyilatkozat>> maganemberAdobevallas(@PathVariable @Positive Long id) {
        Optional<Ceg> ceg = cegRepository.findById(id);
        if (!ceg.isPresent()) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        adobevallasRiport.lekerdezes(ceg.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
