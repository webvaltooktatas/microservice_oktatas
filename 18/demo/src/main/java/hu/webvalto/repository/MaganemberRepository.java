package hu.webvalto.repository;

import hu.webvalto.domain.Maganember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MaganemberRepository extends JpaRepository<Maganember, Long>, JpaSpecificationExecutor<Maganember> {

    @Query("SELECT me FROM Maganember me WHERE me.adoszam =:adoszam")
    Maganember findByAdoszam(@Param("adoszam") String adoszam);

    @Query("SELECT m FROM Maganember m WHERE m.evesBevetel IS NOT NULL")
    List<Maganember> findAllHasEvesBevetel();

    @Query("SELECT SUM(m.evesBevetel) FROM Maganember m WHERE m.evesBevetel IS NOT NULL")
    Long getOsszesBevetel();

    @Query("SELECT SUM(m.evesKiadas) FROM Maganember m WHERE m.evesKiadas IS NOT NULL")
    Long getOsszesKiadas();
}
