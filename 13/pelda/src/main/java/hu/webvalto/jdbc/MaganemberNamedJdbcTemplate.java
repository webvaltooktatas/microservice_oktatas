package hu.webvalto.jdbc;

import hu.webvalto.domain.Maganember;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MaganemberNamedJdbcTemplate {

    @Autowired
    public MaganemberNamedJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        Maganember maganember = jdbcTemplate.queryForObject(
                "SELECT * From maganember WHERE id = :id",
                new MapSqlParameterSource("id", "1"),
                BeanPropertyRowMapper.newInstance(Maganember.class));
        LoggerFactory.getLogger(MaganemberNamedJdbcTemplate.class).info(maganember.toString());
    }
}
