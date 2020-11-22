//package hu.webvalto.jdbc;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//
//import org.h2.Driver;
//import java.sql.SQLException;
//
//public class SpringJdbcDemo {
//
//    public static void main(String[] args) throws SQLException {
//
//        SimpleDriverDataSource ds = new SimpleDriverDataSource();
//        ds.setDriverClass(Driver.class);
//        ds.setUrl("jdbc:h2:~/test");
//        ds.setUsername("sa");
//        ds.setPassword("sa");
//
//        JdbcTemplate jtm = new JdbcTemplate(ds);
//        jtm.execute("DROP TABLE test IF EXISTS");
//        jtm.execute("CREATE TABLE test (id SERIAL, name VARCHAR(50))");
//        jtm.execute("INSERT INTO test(id, name) VALUES (1,'Adam')");
//        String sql = "SELECT count(*) FROM test";
//        int id = jtm.queryForObject(sql, Integer.class);
//
//        System.out.format("Number of entry: "+id);
//    }
//}