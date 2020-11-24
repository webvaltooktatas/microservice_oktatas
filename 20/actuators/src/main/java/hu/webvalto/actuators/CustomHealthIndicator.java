package hu.webvalto.actuators;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("alkalmazas", "Bevetesre kesz")
                .withDetail("hibak", "Nulla! Minden okes.");
    }
}