package hu.webvalto;

import com.querydsl.core.types.dsl.BooleanExpression;
import hu.webvalto.domain.Maganember;
import hu.webvalto.domain.QMaganember;
import hu.webvalto.repository.MaganemberRepository;
import hu.webvalto.repository.MaganemberSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(MaganemberRepository maganemberRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(MainApplication.class);
            logger.info("KERESETT ENTITAS: " + maganemberRepository.findByNev("Marti"));
            logger.info("KERESETT ENTITAS: " + maganemberRepository.findByAdoszamAlapjan("123456789"));
            logger.info("KERESETT ENTITAS: " + maganemberRepository.findAll(MaganemberSpecification.vanAdoszama().and(MaganemberSpecification.vanEvesBevetele())));

            BooleanExpression vanAdoszama = QMaganember.maganember.adoszam.isNotNull();
            BooleanExpression vanEvesBevetele = QMaganember.maganember.evesBevetel.gt(0);
            logger.info("KERESETT ENTITASOK: " + maganemberRepository.findAll(vanAdoszama.and(vanEvesBevetele)));
            logger.info("KERESETT ENTITASOK: " + maganemberRepository.akinekTobbABeveteleMintEgyMillio());
        };
    }
}
