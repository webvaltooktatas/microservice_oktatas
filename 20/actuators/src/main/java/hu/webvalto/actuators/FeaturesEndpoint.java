package hu.webvalto.actuators;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "szolgaltatasok")
public class FeaturesEndpoint {
 
    private Map<String, String> features = new ConcurrentHashMap<>();

    public FeaturesEndpoint() {
        this.features.put("teszt", "asd");
        this.features.put("teszt2", "qwe");
    }

    @ReadOperation
    public Map<String, String> features() {
        return features;
    }
 
    @ReadOperation
    public String feature(@Selector String name) {
        return features.get(name);
    }


}