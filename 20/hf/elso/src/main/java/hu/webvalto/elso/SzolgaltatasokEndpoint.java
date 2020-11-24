package hu.webvalto.elso;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "szolgaltatasok")
public class SzolgaltatasokEndpoint {

    private List<String> szolgaltatasok = new ArrayList<>();

    public SzolgaltatasokEndpoint() {
        this.szolgaltatasok.add("jövőbe látás");
        this.szolgaltatasok.add("főzés");
        this.szolgaltatasok.add("mosogatás");
    }

    @ReadOperation
    public List<String> getSzolgaltatasok() {
        return szolgaltatasok;
    }

}