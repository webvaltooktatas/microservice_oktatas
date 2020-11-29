package hu.webvalto.bevallaslekerdezes.repository;

import hu.webvalto.bevallaslekerdezes.domain.Maganember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaganemberRepository extends JpaRepository<Maganember, Long> {
}
