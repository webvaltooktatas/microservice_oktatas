package hu.webvalto.config;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //Meghivodik az init metodusa a Ceg Bean-nek a bean inicializalasakor
    @Bean(initMethod = "init")
    public Ceg ceg1(Cim cim, Maganember maganember1) {
        cim.setVaros("Miskolc");
        cim.setUtca("Harmat");
        cim.setHazszam("115/A");
        cim.setIranyitoszam("3698");
        Ceg ceg = new Ceg("Good Trade", cim, "963852741", maganember1);
        ceg.setEvesBevetel(8900000L);
        ceg.setEvesKiadas(15000000L);
        return ceg;
    }

    //Cim injektalasa parameterkent, lathato hogy nincs szukseg @Autowired-re
    @Bean(initMethod = "init")
    public Ceg ceg2(Cim cim, Maganember maganember2) {
        cim.setVaros("Ujfalu");
        cim.setUtca("Kiss Lajos");
        cim.setHazszam("11");
        cim.setIranyitoszam("7456");
        Ceg ceg = new Ceg("Ujfalui Dohanybolt", cim, "36985217", maganember2);
        ceg.setEvesBevetel(3500000L);
        ceg.setEvesKiadas(150000L);
        return ceg;
    }

    @Bean(initMethod = "init")
    public Maganember maganember1(Cim cim) {
        Maganember maganember = new Maganember("Kiss Lajos", "123456789");
        cim.setVaros("Budapest");
        cim.setUtca("Kossuth");
        cim.setHazszam("37");
        cim.setIranyitoszam("1011");
        maganember.setCim(cim);
        maganember.setEvesBevetel(150000L);
        maganember.setEvesKiadas(5800L);
        return maganember;
    }


    @Bean(initMethod = "init")
    public Maganember maganember2(Cim cim) {
        Maganember maganember = new Maganember("Nagy Marta", "987654321");
        cim.setVaros("Szeged");
        cim.setUtca("Petofi");
        cim.setHazszam("11");
        cim.setIranyitoszam("8011");
        maganember.setCim(cim);
        maganember.setEvesKiadas(25000L);
        return maganember;
    }
}
