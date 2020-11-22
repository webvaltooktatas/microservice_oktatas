package hu.webvalto.repository;

import hu.webvalto.domain.Ceg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CegRepository extends JpaRepository<Ceg, Long>, JpaSpecificationExecutor<Ceg> {

    @Query("SELECT c FROM Ceg c WHERE c.adoszam =:adoszam")
    Ceg findByAdoszam(@Param("adoszam") String adoszam);

    @Query("SELECT c FROM Ceg c WHERE c.evesBevetel IS NOT NULL")
    List<Ceg> findAllHasEvesBevetel();

    @Query("SELECT SUM(c.evesBevetel) FROM Ceg c WHERE c.evesBevetel IS NOT NULL")
    Long getOsszesBevetel();

    @Query("SELECT SUM(c.evesKiadas) FROM Ceg c WHERE c.evesKiadas IS NOT NULL")
    Long getOsszesKiadas();

}
