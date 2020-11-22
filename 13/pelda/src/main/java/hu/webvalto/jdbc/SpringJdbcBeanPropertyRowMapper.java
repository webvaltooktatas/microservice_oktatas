package hu.webvalto.jdbc;

import hu.webvalto.domain.Maganember;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcBeanPropertyRowMapper {

    @Autowired
    public SpringJdbcBeanPropertyRowMapper(JdbcTemplate jdbcTemplate) {
        Maganember maganember = jdbcTemplate.queryForObject("SELECT * From maganember WHERE id = 1", BeanPropertyRowMapper.newInstance(Maganember.class));
        LoggerFactory.getLogger(SpringJdbcBeanPropertyRowMapper.class).info(maganember.toString());
    }
}
