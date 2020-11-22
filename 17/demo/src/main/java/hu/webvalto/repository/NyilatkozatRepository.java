package hu.webvalto.repository;

import hu.webvalto.domain.Adozo;
import hu.webvalto.domain.Nyilatkozat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NyilatkozatRepository extends MongoRepository<Nyilatkozat, String> {

    Nyilatkozat findByNyilatkozatTevo(Adozo adozo);

    List<Nyilatkozat> findAllByNyilatkozatTevo(Adozo adozo);
}
