package hu.webvalto.repository;

import hu.webvalto.domain.Nyilatkozat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NyilatkozatRepository extends MongoRepository<Nyilatkozat, String> {

    Nyilatkozat findByNev(String nev);
}
