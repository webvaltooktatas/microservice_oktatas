package hu.webvalto;

import hu.webvalto.config.AppPropeties;
import hu.webvalto.service.AdobevallasRiport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private AppPropeties appPropeties;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(ApplicationContext ctx, AdobevallasRiport adobevallasRiport) {
        return args -> {
            System.out.println(appPropeties.getName() + " Spring Boot applikacio elindult");
            System.out.println(appPropeties.getDescription());
            System.out.println(appPropeties.getPort());
            adobevallasRiport.lekerdezes();
        };
    }
}
