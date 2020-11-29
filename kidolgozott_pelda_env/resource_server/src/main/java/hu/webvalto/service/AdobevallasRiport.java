package hu.webvalto.service;

import hu.webvalto.domain.Adozo;
import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import hu.webvalto.repository.CegRepository;
import hu.webvalto.repository.MaganemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdobevallasRiport {

    private static final Logger logger = LoggerFactory.getLogger(AdobevallasRiport.class);

    private final Adobevallas adobevallas;
    private final MaganemberRepository maganemberRepository;
    private final NyilatkozatService nyilatkozatService;
    private final CegRepository cegRepository;


    public AdobevallasRiport(Adobevallas adobevallas, MaganemberRepository maganemberRepository, CegRepository cegRepository, NyilatkozatService nyilatkozatService) {
        this.adobevallas = adobevallas;
        this.maganemberRepository = maganemberRepository;
        this.cegRepository = cegRepository;
        this.nyilatkozatService = nyilatkozatService;
    }

    public void lekerdezesMaganszemelyek() {
        List<Maganember> maganemberek = maganemberRepository.findAll();

        for (Maganember maganember : maganemberek) {
            lekerdezes(maganember);
        }

    }

    public void lekerdezesCegek() {
        List<Ceg> cegek = cegRepository.findAll();
        for (Ceg ceg : cegek) {
            lekerdezes(ceg);
        }
    }

    public void lekerdezes(Adozo adozo) {
        double ado = adobevallas.befizetendoAdo(adozo);
        nyilatkozatService.ujNyilatkozat(adozo, "adobevallas", ado);
        logger.info(adozo.getNev() + " adozando osszege: " + ado + " Ft");
    }
}
