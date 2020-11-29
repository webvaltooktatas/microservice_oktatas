package org.springframework.security.oauth.samples;

import hu.webvalto.config.LogConfiguration;
import hu.webvalto.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication()
@Import({WebConfiguration.class, LogConfiguration.class})
public class OAuthClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(OAuthClientApplication.class, args);
    }
}