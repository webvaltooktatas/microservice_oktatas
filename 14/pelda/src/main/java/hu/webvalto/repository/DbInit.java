package hu.webvalto.repository;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbInit {

    @Autowired
    public DbInit(JdbcTemplate jdbcTemplate, MaganemberRepository maganemberRepository, CegRepository cegRepository, CimRepository cimRepository) {
        jdbcTemplate.execute("DROP TABLE IF EXISTS maganember");
        jdbcTemplate.execute("DROP TABLE IF EXISTS ceg");
        jdbcTemplate.execute("DROP TABLE IF EXISTS cim");

        jdbcTemplate.execute("CREATE TABLE maganember (id SERIAL NOT NULL AUTO_INCREMENT, nev VARCHAR(50), adoszam VARCHAR(12), cim_id INTEGER, eves_bevetel INTEGER, eves_kiadas INTEGER)");
        jdbcTemplate.execute("CREATE TABLE ceg (id SERIAL NOT NULL AUTO_INCREMENT, cegnev VARCHAR(50), adoszam VARCHAR(12), szekhely_id INTEGER, tulajdonos_id INTEGER, eves_bevetel INTEGER, eves_kiadas INTEGER)");
        jdbcTemplate.execute("CREATE TABLE cim (id SERIAL NOT NULL AUTO_INCREMENT, varos VARCHAR(50), utca VARCHAR(50), hazszam VARCHAR(50), iranyitoszam VARCHAR(10))");


        Maganember maganember1 = new Maganember();
        maganember1.setNev("Adam");
        maganember1.setAdoszam("123456789");
        maganember1.setEvesBevetel(50000000L);
        maganember1.setEvesKiadas(150L);
        maganemberRepository.save(maganember1);

        Maganember maganember2 = new Maganember();
        maganember2.setNev("Marti");
        maganember2.setAdoszam("987654321");
        maganember2.setEvesBevetel(150000L);
        maganemberRepository.save(maganember2);

        Cim cim = new Cim();
        cim.setVaros("Budapest");
        cim.setUtca("Kossuth");
        cim.setHazszam("11");
        cim.setIranyitoszam("1111");
        cimRepository.save(cim);

        Ceg ceg = new Ceg();
        ceg.setNev("Johirnevu Dohanybolt");
        ceg.setAdoszam("9876543221");
        ceg.setEvesBevetel(3500000L);
        ceg.setEvesKiadas(157888L);
        ceg.setTulajdonos(maganember1);
        ceg.setSzekhely(cim);
        cegRepository.save(ceg);
    }
}
