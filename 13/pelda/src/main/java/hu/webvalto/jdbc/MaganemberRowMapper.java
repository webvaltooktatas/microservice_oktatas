package hu.webvalto.jdbc;

import hu.webvalto.domain.Maganember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaganemberRowMapper implements RowMapper<Maganember> {
    @Override
    public Maganember mapRow(ResultSet rs, int rowNum) throws SQLException {
        Maganember maganember = new Maganember(
                rs.getString("nev"),
                rs.getString("adoszam")
        );
        maganember.setEvesKiadas(rs.getLong("evesKiadas"));
        maganember.setEvesBevetel(rs.getLong("evesBevetel"));

        return maganember;
    }
}
