package hu.webvalto.demo;

import hu.webvalto.demo.domain.Cim;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hu.webvalto")
public class AppConfig {

    @Bean
    @Qualifier("alternativ")
    public Cim alternativCim() {
        return new Cim();
    }

    @Bean
    public Cim cim(){
        return new Cim("Budapest", "Kossuth", "37");
    }
}
