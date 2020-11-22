package hu.webvalto.mapper;

import hu.webvalto.domain.Ceg;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CegPropertyMapper implements RowMapper<Ceg> {
    @Override
    public Ceg mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ceg ceg = new Ceg();

        ceg.setNev(rs.getString("cegnev"));
        ceg.setEvesBevetel(rs.getLong("evesBevetel"));
        ceg.setAdoszam(rs.getString("adoszam"));
        ceg.setEvesKiadas(rs.getLong("evesKiadas"));
        return ceg;
    }
}
