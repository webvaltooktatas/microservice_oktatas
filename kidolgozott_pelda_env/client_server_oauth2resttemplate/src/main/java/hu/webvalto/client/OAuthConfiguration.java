package hu.webvalto.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OAuthConfiguration {


    @Bean
    public RestTemplate restTemplate() {
        String url = "http://localhost:8080/auth/realms/test/protocol/openid-connect/token";

        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setAccessTokenUri(url);
        resourceDetails.setClientId("client_one");
        resourceDetails.setClientSecret("93a25c1c-a887-447a-a0cb-b62c7b359310");

        List<String> scopes = new ArrayList<>();
        scopes.add("read");
        scopes.add("write");
        resourceDetails.setScope(scopes);

        RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
        return restTemplate;
    }
}
