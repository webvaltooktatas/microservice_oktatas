package org.springframework.security.oauth.samples.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2AuthorizedClientInterceptor implements ClientHttpRequestInterceptor {
    OAuth2AuthorizedClientManager manager;

    public OAuth2AuthorizedClientInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        Authentication principal = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId("client_one")
                .principal(principal)
                .build();
        OAuth2AuthorizedClient authorizedClient =
                this.manager.authorize(authorizeRequest);

        HttpHeaders headers = request.getHeaders();
        headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());

        return execution.execute(request, body);
    }
}
