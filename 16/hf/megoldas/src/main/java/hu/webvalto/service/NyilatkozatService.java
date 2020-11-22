package hu.webvalto.service;

import hu.webvalto.domain.Adozo;
import hu.webvalto.domain.Nyilatkozat;
import hu.webvalto.repository.NyilatkozatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class NyilatkozatService {

    private NyilatkozatRepository repository;

    @Autowired
    public NyilatkozatService(NyilatkozatRepository repository) {
        this.repository = repository;
    }

    public void ujNyilatkozat(Adozo adozo, String tipus, Double adozandoOsszeg) {
        Nyilatkozat elozoNyilatkozat = repository.findByNyilatkozatTevo(adozo);

        Nyilatkozat ujNyilatkozat = new Nyilatkozat();
        ujNyilatkozat.setId(UUID.randomUUID().toString());
        ujNyilatkozat.setKapcsolodoNyilatkozat(elozoNyilatkozat);
        ujNyilatkozat.setNyilatkozatTevo(adozo);
        ujNyilatkozat.setNyilatkozatTevesIdeje(LocalDate.now());
        ujNyilatkozat.setNyilatkozatTevoEvesBevetele(adozo.getEvesBevetel());
        ujNyilatkozat.setNyilatkozatTevoEvesKiadasa(adozo.getEvesKiadas());
        ujNyilatkozat.setNyilatkozatAdozandoOsszeg(adozandoOsszeg);
        ujNyilatkozat.setTipus(tipus);

        repository.save(ujNyilatkozat);
    }

    public List<Nyilatkozat> nyilatkozatokLekerdezese(Adozo adozo) {
        return repository.findAllByNyilatkozatTevo(adozo);
    }
}
