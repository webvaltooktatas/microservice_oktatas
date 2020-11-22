package hu.webvalto;

import hu.webvalto.domain.Maganember;
import hu.webvalto.domain.Nyilatkozat;
import hu.webvalto.repository.NyilatkozatRepository;
import hu.webvalto.service.AdobevallasRiport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@SpringBootApplication
public class MainApplication {
    public static Logger logger = LoggerFactory.getLogger(MainApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(NyilatkozatRepository nyilatkozatRepository) throws Exception {
        return args -> {
            //mongoTemplate.dropCollection(Nyilatkozat.class);

            Maganember maganember = new Maganember();
            maganember.setId(3L);
            maganember.setNev("Adam");
            maganember.setAdoszam("123456789");

            Nyilatkozat nyilatkozat = new Nyilatkozat();
            nyilatkozat.setId("5");
            nyilatkozat.setNev("Adam alnyilatkozat");
            nyilatkozat.setLeiras("Adam alnyilatkozata");
            nyilatkozatRepository.insert(nyilatkozat);

            Nyilatkozat fonyilatkozat = new Nyilatkozat();
            fonyilatkozat.setId("7");
            fonyilatkozat.setNev("Adam");
            fonyilatkozat.setLeiras("Adam nyilatkozata");
            fonyilatkozat.setTulajdonos(maganember);
            fonyilatkozat.setAlnyilatkozat(nyilatkozat);

            nyilatkozatRepository.insert(fonyilatkozat);

            fonyilatkozat.setLeiras("random leiras");
            nyilatkozatRepository.save(fonyilatkozat);

            //mongoTemplate.updateFirst(query(where("nev").is("Adam")), update("leiras", "Adamka nyilakozata"), Nyilatkozat.class);

            logger.info(""+nyilatkozatRepository.findByNev("Adam"));
        };
    }
}
