package hu.webvalto;

import hu.webvalto.service.AdobevallasRiport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdobevallasRiportIT {

    @Autowired
    private AdobevallasRiport adobevallasRiport;

    @Test
    public void lekerdezes() {
        adobevallasRiport.lekerdezes();
    }
}
