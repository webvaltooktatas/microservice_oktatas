package hu.webvalto.jpa;

import hu.webvalto.domain.Maganember;
import org.springframework.data.jpa.domain.Specification;

public class MaganemberSpecification {
    public static Specification<Maganember> vanAdoszama() {
        return (Specification<Maganember>) (root, query, cb) -> cb.notEqual(root.get("adoszam"), null);
    }

    public static Specification<Maganember> vanEvesBevetele() {
        return (Specification<Maganember>) (root, query, cb) -> cb.greaterThan(root.get("evesBevetel"), 0);
    }
}
