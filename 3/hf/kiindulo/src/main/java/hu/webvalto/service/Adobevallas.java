package hu.webvalto.service;


import hu.webvalto.domain.Adozo;
import org.springframework.stereotype.Service;

@Service
public class Adobevallas {

    public double befizetendoAdo(Adozo adozo) {
        System.out.println("Adobevallas elkeszitese " + adozo.getNev() + "-nak");
        double befizetendoAdo;
        //Ha nem volt bevetele
        if (adozo.getEvesBevetel() == null) {
            return 0L;
        }
        //Ha nem volt kiadasa
        if (adozo.getEvesKiadas() == null) {
            befizetendoAdo = adozo.getEvesBevetel() * adozo.getAdokulcs();
        } else {
            //Ha volt bevetele es kiadasa is
            befizetendoAdo = (adozo.getEvesBevetel() - adozo.getEvesKiadas()) * adozo.getAdokulcs();
        }
        //Negativ ado nincs, igy negativ szam eseten 0-val terunk vissza
        return befizetendoAdo > 0 ? befizetendoAdo : 0L;
    }
}
