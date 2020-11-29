package hu.webvalto.service;


import hu.webvalto.domain.Adozo;
import hu.webvalto.domain.Ceg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Adobevallas {

    @Value("${cegAdokulcs}")
    private Double cegAdokulcs;
    @Value("${maganemberAdokulcs}")
    private Double maganemberAdokulcs;

    public double befizetendoAdo(Adozo adozo) {
        if (adozo == null) {
            throw new IllegalArgumentException("Muszaj megadni adozot!");
        }
        System.out.println("Adobevallas elkeszitese " + adozo.getNev() + "-nak");
        double befizetendoAdo;
        //Ha nem volt bevetele
        if (adozo.getEvesBevetel() == null) {
            return 0L;
        }
        //Ha nem volt kiadasa
        if (adozo.getEvesKiadas() == null) {
            befizetendoAdo = adozo.getEvesBevetel() * (adozo instanceof Ceg ? cegAdokulcs : maganemberAdokulcs);
        } else {
            //Ha volt bevetele es kiadasa is
            befizetendoAdo = (adozo.getEvesBevetel() - adozo.getEvesKiadas()) * (adozo instanceof Ceg ? cegAdokulcs : maganemberAdokulcs);
        }
        //Negativ ado nincs, igy negativ szam eseten 0-val terunk vissza
        return befizetendoAdo > 0 ? befizetendoAdo : 0L;
    }
}
