package hu.webvalto.nyilatkozatok.repository;

import hu.webvalto.nyilatkozatok.domain.Nyilatkozat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NyilatkozatRepository extends MongoRepository<Nyilatkozat, String> {

    List<Nyilatkozat> findByAdozo(Long id);
}
