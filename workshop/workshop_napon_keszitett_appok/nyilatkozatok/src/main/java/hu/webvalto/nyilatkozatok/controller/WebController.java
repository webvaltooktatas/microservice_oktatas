package hu.webvalto.nyilatkozatok.controller;

import hu.webvalto.domain.NyilatkozatDTO;
import hu.webvalto.nyilatkozatok.repository.NyilatkozatRepository;
import hu.webvalto.nyilatkozatok.domain.Nyilatkozat;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    private NyilatkozatRepository nyilatkozatRepository;

    @Autowired
    private Logger logger;

    @Autowired
    public WebController(NyilatkozatRepository nyilatkozatRepository) {
        this.nyilatkozatRepository = nyilatkozatRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ceg/{id}/nyilatkozatok")
    public List<NyilatkozatDTO> cegNyilatkozatok(@PathVariable("id") Long id) {
        return getAdozoNyilatkozatok(id);
    }

    @GetMapping("/maganember/{id}/nyilatkozatok")
    public List<NyilatkozatDTO> maganemberNyilatkozatok(@PathVariable("id") Long id) {
        return getAdozoNyilatkozatok(id);
    }

    private List<NyilatkozatDTO> getAdozoNyilatkozatok(Long id) {
        logger.info("Meghivasra kerultem");
        List<Nyilatkozat> nyilatkozatList = nyilatkozatRepository.findByAdozo(id);

        List<NyilatkozatDTO> nyilatkozatDTOS = new ArrayList<>();
        for (Nyilatkozat nyilatkozat : nyilatkozatList) {
            NyilatkozatDTO nyilatkozatDTO = new NyilatkozatDTO();
            nyilatkozatDTO.setAdozo(nyilatkozat.getAdozo());
            nyilatkozatDTO.setId(nyilatkozat.getId());
            nyilatkozatDTO.setBevetel(nyilatkozat.getBevetel());
            nyilatkozatDTO.setKiadas(nyilatkozat.getKiadas());
            nyilatkozatDTO.setLeiras(nyilatkozat.getLeiras());
            nyilatkozatDTO.setTartalom(nyilatkozat.getTartalom());
            nyilatkozatDTOS.add(nyilatkozatDTO);
        }

        return nyilatkozatDTOS;
    }
}
