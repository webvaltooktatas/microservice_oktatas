package hu.webvalto.elso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class WebController {

    private final static Map<Integer, String> randomNevek = new HashMap<>();

    public WebController() {
        randomNevek.put(1, "vándor");
        randomNevek.put(2, "idegen");
        randomNevek.put(3, "barát");
    }

    @GetMapping(value = "/", produces = "application/json")
    public Hello index() {
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        String uzenet = "Hello " + randomNevek.get(i) + ", eme csodás napon";
        return new Hello(randomNevek.get(i), LocalTime.now(), uzenet);
    }
}
