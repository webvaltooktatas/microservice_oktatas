package hu.webvalto.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String correlationId = request.getHeader("X-Correlation-Id");
        if (correlationId == null) {
            correlationId = getCorrelationId();
        }
        MDC.put("correlationId", correlationId);
        return super.preHandle(request, response, handler);
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
