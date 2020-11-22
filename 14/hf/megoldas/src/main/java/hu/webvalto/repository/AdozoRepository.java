package hu.webvalto.repository;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import hu.webvalto.mapper.CegPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.jta.UserTransactionAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdozoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    @Autowired
    public AdozoRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<Maganember> getMaganEmberek() {
        return jdbcTemplate.query("SELECT * FROM maganember", BeanPropertyRowMapper.newInstance(Maganember.class));
    }

    public List<Ceg> getCegek() {
        return jdbcTemplate.query("SELECT * FROM ceg", new CegPropertyMapper());
    }

    public Maganember getMaganemberById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM maganember WHERE id = ?", new Object[]{id}, BeanPropertyRowMapper.newInstance(Maganember.class));
    }

    public Ceg getCegById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ceg WHERE id = ?", new Object[]{id}, new CegPropertyMapper());
    }

    public void addUjMaganember(Maganember maganember) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nev", maganember.getNev());
        parameters.put("adoszam", maganember.getAdoszam());
        parameters.put("evesBevetel", maganember.getEvesBevetel());
        parameters.put("evesKiadas", maganember.getEvesKiadas());

        new SimpleJdbcInsert(dataSource).withTableName("maganember").execute(parameters);
    }

    public void addUjCeg(Ceg ceg) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cegnev", ceg.getNev());
        parameters.put("adoszam", ceg.getAdoszam());
        parameters.put("evesBevetel", ceg.getEvesBevetel());
        parameters.put("evesKiadas", ceg.getEvesKiadas());

        new SimpleJdbcInsert(dataSource).withTableName("ceg").execute(parameters);
    }

    public void modifyMaganember(Integer id, Maganember maganember) {
        jdbcTemplate.update("UPDATE maganember SET nev = ?, adoszam = ?, evesBevetel = ?, evesKiadas = ? WHERE id = ?",
                maganember.getNev(), maganember.getAdoszam(), maganember.getEvesBevetel(), maganember.getEvesKiadas(), id);
    }

    public void modifyCeg(Integer id, Ceg ceg) {
        jdbcTemplate.update("UPDATE ceg SET cegnev = ?, adoszam = ?, evesBevetel = ?, evesKiadas = ? WHERE id = ?",
                ceg.getNev(), ceg.getAdoszam(), ceg.getEvesBevetel(), ceg.getEvesKiadas(), id);
    }

    public void removeMaganember(Integer id) {
        jdbcTemplate.update("DELETE FROM maganember WHERE id = ? ", id);
    }

    public void removeCeg(Integer id) {
        jdbcTemplate.update("DELETE FROM ceg WHERE id = ? ", id);
    }
}
