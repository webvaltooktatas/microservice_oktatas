package hu.webvalto.controller;

import hu.webvalto.domain.Maganember;
import hu.webvalto.domain.Nyilatkozat;
import hu.webvalto.repository.MaganemberRepository;
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
@RequestMapping("/maganember")
public class MaganemberAdobevallasController {
    @Autowired
    private Logger logger;
    private final MaganemberRepository maganemberRepository;
    private final NyilatkozatService nyilatkozatService;
    private final AdobevallasRiport adobevallasRiport;

    @Autowired
    public MaganemberAdobevallasController(MaganemberRepository maganemberRepository, NyilatkozatService nyilatkozatService, AdobevallasRiport adobevallasRiport) {
        this.maganemberRepository = maganemberRepository;
        this.nyilatkozatService = nyilatkozatService;
        this.adobevallasRiport = adobevallasRiport;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberLetrehozas(@Valid @RequestBody Maganember maganember) {
        maganemberRepository.save(maganember);
        return new ResponseEntity<>("Letrehozva", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Maganember> maganemberLekerdezes(@PathVariable @Positive Long id) {
        Optional<Maganember> maganember = maganemberRepository.findById(id);
        if (!maganember.isPresent()) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maganember.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> maganemberModositas(@PathVariable @Positive Long id, @RequestBody Maganember maganember) {
        boolean letezik = maganemberRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        maganemberRepository.save(maganember);
        return new ResponseEntity<>("Modositva", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Maganember> maganemberTorlese(@PathVariable @Positive Long id) {
        boolean letezik = maganemberRepository.existsById(id);
        if (!letezik) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        maganemberRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/nyilatkozatok")
    public ResponseEntity<List<Nyilatkozat>> maganemberNyilatkozatok(@PathVariable @Positive Long id) {
        Optional<Maganember> maganember = maganemberRepository.findById(id);
        if (!maganember.isPresent()) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nyilatkozatService.nyilatkozatokLekerdezese(maganember.get()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/adobevallas")
    public ResponseEntity<List<Nyilatkozat>> maganemberAdobevallas(@PathVariable @Positive Long id) {
        Optional<Maganember> maganember = maganemberRepository.findById(id);
        if (!maganember.isPresent()) {
            logger.error("Nem talalhato a keresett maganember");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        adobevallasRiport.lekerdezes(maganember.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
