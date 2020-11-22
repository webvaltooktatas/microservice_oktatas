package hu.webvalto.repository;

import hu.webvalto.domain.Cim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CimRepository extends JpaRepository<Cim, Long> {
}
