package hu.webvalto.repository;

import hu.webvalto.domain.Maganember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaganemberRepository extends JpaRepository<Maganember, Long>, JpaSpecificationExecutor<Maganember>, QuerydslPredicateExecutor<Maganember> {

    Maganember findByNev(String nev);

    @Query("SELECT me FROM Maganember me WHERE me.adoszam = :adoazonosito")
    Maganember findByAdoszamAlapjan(@Param("adoazonosito") String adoszam);

    List<Maganember> akinekTobbABeveteleMintEgyMillio();
}
