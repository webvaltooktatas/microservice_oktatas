package hu.webvalto.masodik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MasodikApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate httpBasicRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.basicAuthentication("test", "test").build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MasodikApplication.class, args);
    }

}
