package hu.webvalto.actuators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableScheduling
@SpringBootApplication
public class ActuatorsApplication {


    @Bean
    public InMemoryAuditEventRepository repository(){
        return new InMemoryAuditEventRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(ActuatorsApplication.class, args);
    }

}
