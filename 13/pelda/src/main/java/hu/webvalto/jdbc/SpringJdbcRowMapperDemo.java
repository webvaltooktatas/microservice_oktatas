package hu.webvalto.jdbc;

import hu.webvalto.domain.Maganember;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcRowMapperDemo {

    @Autowired
    public SpringJdbcRowMapperDemo(JdbcTemplate jdbcTemplate) {
        Maganember maganember = jdbcTemplate.queryForObject("SELECT * From maganember WHERE id = 1", new MaganemberRowMapper());
        LoggerFactory.getLogger(SpringJdbcRowMapperDemo.class).info(maganember.toString());

         List<Maganember> maganemberLista = jdbcTemplate.query(
                 "SELECT * From maganember WHERE id = ?",
                 new Object[]{"1"},
                 new MaganemberRowMapper());
        LoggerFactory.getLogger(SpringJdbcRowMapperDemo.class).info(maganemberLista.toString());

         maganemberLista = jdbcTemplate.query(
                "SELECT * From maganember",
                new MaganemberRowMapper());
        LoggerFactory.getLogger(SpringJdbcRowMapperDemo.class).info(maganemberLista.toString());


    }
}
