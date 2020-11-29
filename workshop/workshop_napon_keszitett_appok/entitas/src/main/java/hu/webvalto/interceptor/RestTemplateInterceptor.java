package hu.webvalto.interceptor;

import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().add("X-Correlation-ID", MDC.get("correlationId"));
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, body);
        response.getHeaders().add("X-Correlation-ID", MDC.get("CorrelationId"));
        return response;
    }
}
