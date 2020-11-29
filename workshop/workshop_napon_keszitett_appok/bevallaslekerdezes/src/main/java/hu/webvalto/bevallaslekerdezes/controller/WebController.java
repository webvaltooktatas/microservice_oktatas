package hu.webvalto.bevallaslekerdezes.controller;

import hu.webvalto.bevallaslekerdezes.domain.Ceg;
import hu.webvalto.bevallaslekerdezes.domain.Maganember;
import hu.webvalto.bevallaslekerdezes.repository.CegRepository;
import hu.webvalto.bevallaslekerdezes.repository.MaganemberRepository;
import hu.webvalto.domain.CegDTO;
import hu.webvalto.domain.CimDTO;
import hu.webvalto.domain.MaganemberDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {
    private final MaganemberRepository maganemberRepository;
    private final CegRepository cegRepository;

    @Autowired
    private Logger logger;

    private final RestTemplate restTemplate;

    @Autowired
    public WebController(MaganemberRepository maganemberRepository, CegRepository cegRepository, RestTemplate restTemplate) {
        this.maganemberRepository = maganemberRepository;
        this.cegRepository = cegRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/maganember")
    public List<MaganemberDTO> maganemberList() {
        logger.info("Meghivasra kerultem");
        List<Maganember> maganemberList = maganemberRepository.findAll();
        List<MaganemberDTO> maganemberDTOList = new ArrayList<>();
        for (Maganember maganember : maganemberList) {
            MaganemberDTO maganemberDTO = new MaganemberDTO();
            maganemberDTO.setNev(maganember.getNev());
            maganemberDTO.setAdokulcs(maganember.getAdokulcs());
            if (maganemberDTO.getCim() != null) {
                CimDTO cimDTO = new CimDTO();
                cimDTO.setVaros(maganember.getCim().getVaros());
                cimDTO.setHazszam(maganember.getCim().getHazszam());
                cimDTO.setUtca(maganember.getCim().getUtca());
                cimDTO.setIranyitoszam(maganember.getCim().getIranyitoszam());

                maganemberDTO.setCim(cimDTO);
            }

            maganemberDTO.setNyilatkozatDTOS(restTemplate.getForObject("http://localhost:8093/maganember/" + maganember.getId() + "/nyilatkozatok", List.class));
            maganemberDTO.setAdoszam(maganember.getAdoszam());
            maganemberDTO.setId(maganember.getId());
            maganemberDTOList.add(maganemberDTO);
        }


        return maganemberDTOList;
    }

    @GetMapping("/ceg")
    public List<CegDTO> cegList() {
        List<Ceg> cegList = cegRepository.findAll();
        List<CegDTO> cegDTOList = new ArrayList<>();
        for (Ceg ceg : cegList) {
            CegDTO cegDTO = new CegDTO();
            cegDTO.setNev(ceg.getNev());
            cegDTO.setAdokulcs(ceg.getAdokulcs());
            if (ceg.getCim() != null) {
                CimDTO cimDTO = new CimDTO();
                cimDTO.setVaros(ceg.getCim().getVaros());
                cimDTO.setHazszam(ceg.getCim().getHazszam());
                cimDTO.setUtca(ceg.getCim().getUtca());
                cimDTO.setIranyitoszam(ceg.getCim().getIranyitoszam());
                cegDTO.setCim(cimDTO);
            }
            cegDTO.setNyilatkozatDTOS(restTemplate.getForObject("http://localhost:8093/ceg/" + ceg.getId() + "/nyilatkozatok", List.class));
            cegDTO.setAdoszam(ceg.getAdoszam());
            cegDTO.setId(ceg.getId());
            cegDTOList.add(cegDTO);
        }
        return cegDTOList;
    }
}
