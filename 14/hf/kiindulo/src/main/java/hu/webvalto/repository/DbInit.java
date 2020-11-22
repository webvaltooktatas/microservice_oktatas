package hu.webvalto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DbInit {

    @Autowired
    public DbInit(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        jdbcTemplate.execute("DROP TABLE IF EXISTS maganember");
        jdbcTemplate.execute("DROP TABLE IF EXISTS ceg");

        jdbcTemplate.execute("CREATE TABLE maganember (id SERIAL NOT NULL AUTO_INCREMENT, nev VARCHAR(50), adoszam VARCHAR(12), evesBevetel INTEGER, evesKiadas INTEGER)");
        jdbcTemplate.execute("CREATE TABLE ceg (id SERIAL NOT NULL AUTO_INCREMENT, cegnev VARCHAR(50), adoszam VARCHAR(12), evesBevetel INTEGER, evesKiadas INTEGER)");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nev", "Adam");
        parameters.put("adoszam", "12345678");
        parameters.put("evesBevetel", 0);
        parameters.put("evesKiadas", 150);

        new SimpleJdbcInsert(dataSource).withTableName("maganember").execute(parameters);

        parameters.put("nev", "Marti");
        parameters.put("adoszam", "987654321");
        parameters.put("evesBevetel", 150000);
        parameters.put("evesKiadas", 0);

        new SimpleJdbcInsert(dataSource).withTableName("maganember").execute(parameters);

        parameters.put("cegnev", "Johirnevu Dohanybolt");
        parameters.put("adoszam", "9876543221");
        parameters.put("evesBevetel", 3500000);
        parameters.put("evesKiadas", 157888);

        new SimpleJdbcInsert(dataSource).withTableName("ceg").execute(parameters);
    }
}
