package hu.webvalto;

import hu.webvalto.service.AdobevallasRiport;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(ApplicationContext ctx, AdobevallasRiport adobevallasRiport) {
        return args -> {
            System.out.println("Spring Boot applikacio elindult");
            adobevallasRiport.lekerdezes();
        };
    }
}
