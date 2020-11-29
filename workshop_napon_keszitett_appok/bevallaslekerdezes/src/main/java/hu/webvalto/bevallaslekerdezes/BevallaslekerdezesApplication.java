package hu.webvalto.bevallaslekerdezes;

import hu.webvalto.config.LogConfiguration;
import hu.webvalto.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfiguration.class, LogConfiguration.class})
public class BevallaslekerdezesApplication {


    public static void main(String[] args) {
        SpringApplication.run(BevallaslekerdezesApplication.class, args);
    }

}
