package hu.webvalto.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcDemo2 {

    @Autowired
    public SpringJdbcDemo2(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("DROP TABLE IF EXISTS maganember ");
        jdbcTemplate.execute("CREATE TABLE maganember (id SERIAL, nev VARCHAR(50), adoszam VARCHAR(11), evesBevetel INTEGER, evesKiadas INTEGER)");
        jdbcTemplate.execute("INSERT INTO maganember(id, nev, adoszam) VALUES (1,'Adam','12345678')");
        jdbcTemplate.execute("INSERT INTO maganember(id, nev, adoszam) VALUES (2,'Marta','98765432')");
        String sql = "SELECT count(*) FROM maganember";
        int id = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println("Number of entry: " + id);
    }
}
