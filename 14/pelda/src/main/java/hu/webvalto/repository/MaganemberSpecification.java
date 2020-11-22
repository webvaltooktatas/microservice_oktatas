package hu.webvalto.repository;

import hu.webvalto.domain.Maganember;
import org.springframework.data.jpa.domain.Specification;

public class MaganemberSpecification {

    public static Specification<Maganember> vanAdoszama() {
        return (Specification<Maganember>) (root, query, cb) -> cb.isNotNull(root.get("adoszam"));
    }

    public static Specification<Maganember> vanEvesBevetele() {
        return (Specification<Maganember>) (root, query, cb) -> cb.greaterThan(root.get("evesBevetel"), 0);
    }
}
