package hu.webvalto.github;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Github {

    private static final String url = "https://github.com/settings/profile";

    private String accessToken;

    private RestTemplate restTemplate;

    public Github(String accessToken) {
        this.accessToken = accessToken;
        this.restTemplate = new RestTemplate();
        this.restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
    }

    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
        return new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().add("Authorization", "Bearer " + accessToken);
                return execution.execute(request, body);
            }
        };
    }

    public String getInfo() {
        return restTemplate.getForObject(url, String.class);
    }
}
