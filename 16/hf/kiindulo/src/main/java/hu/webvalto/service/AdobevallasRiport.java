package hu.webvalto.service;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import hu.webvalto.repository.CegRepository;
import hu.webvalto.repository.MaganemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdobevallasRiport {
    private Adobevallas adobevallas;
    private MaganemberRepository maganemberRepository;
    private CegRepository cegRepository;


    public AdobevallasRiport(Adobevallas adobevallas, MaganemberRepository maganemberRepository, CegRepository cegRepository) {
        this.adobevallas = adobevallas;
        this.maganemberRepository = maganemberRepository;
        this.cegRepository = cegRepository;
    }

    public String lekerdezesMaganszemelyek() {
        StringBuilder lekerdezes = new StringBuilder();
        List<Maganember> maganemberek = maganemberRepository.findAll();
        double ado = 0;
        for (Maganember maganember : maganemberek) {
            ado = +adobevallas.befizetendoAdo(maganember);
            lekerdezes.append(maganember.getNev() + " maganember befizetett: " + ado + " Ft");
        }

        return lekerdezes.toString();
    }


    public String lekerdezesCegek() {
        StringBuilder lekerdezes = new StringBuilder();
        double ado = 0;
        List<Ceg> cegek = cegRepository.findAll();
        for (Ceg ceg : cegek) {
            ado = +adobevallas.befizetendoAdo(ceg);
            lekerdezes.append(ceg.getNev() + " maganember befizetett: " + ado + " Ft");
        }

        return lekerdezes.toString();
    }
}
