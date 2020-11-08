package hu.webvalto.config;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import hu.webvalto.service.Adobevallas;
import hu.webvalto.service.AdobevallasRiport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Scope("prototype")
    @Bean
    public Cim cim() {
        //Ez is hasznalhato, hogy konzolra irassuk ha ez a Bean letrehozasra kerul
        System.out.println("Cim letre lett hozva!");
        return new Cim();
    }

    //Meghivodik az init metodusa a Ceg Bean-nek a bean inicializalasakor
    @Bean(initMethod = "init")
    public Ceg ceg1(Cim cim) {
        cim.setVaros("Miskolc");
        cim.setUtca("Harmat");
        cim.setHazszam("115/A");
        cim.setIranyitoszam("3698");
        Ceg ceg = new Ceg("Good Trade", cim, "963852741", maganember1());
        ceg.setEvesBevetel(8900000L);
        ceg.setEvesKiadas(15000000L);
        return ceg;
    }

    //Cim injektalasa parameterkent, lathato hogy nincs szukseg @Autowired-re
    @Bean(initMethod = "init")
    public Ceg ceg2(Cim cim) {
        cim.setVaros("Ujfalu");
        cim.setUtca("Kiss Lajos");
        cim.setHazszam("11");
        cim.setIranyitoszam("7456");
        Ceg ceg = new Ceg("Ujfalui Dohanybolt", cim, "36985217", maganember2());
        ceg.setEvesBevetel(3500000L);
        ceg.setEvesKiadas(150000L);
        return ceg;
    }

    @Bean(initMethod = "init")
    public Maganember maganember1() {
        Maganember maganember = new Maganember("Kiss Lajos", "123456789");
        Cim cim = cim();
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
    public Maganember maganember2() {
        Maganember maganember = new Maganember("Nagy Marta", "987654321");
        //Cim injektalasa
        Cim cim = cim();
        cim.setVaros("Szeged");
        cim.setUtca("Petofi");
        cim.setHazszam("11");
        cim.setIranyitoszam("8011");
        maganember.setCim(cim);
        maganember.setEvesKiadas(25000L);
        return maganember;
    }


    @Bean
    public Adobevallas adobevallas() {
        return new Adobevallas();
    }

    //Egy jo pelda, hogy tobbfele strategiat is hasznalhatunk arra, hogy beinjektaljunk fuggoseget,
    // akar hibrid megoldasokat is
    @Bean
    public AdobevallasRiport adobevallasRiport(Ceg ceg1, Ceg ceg2) {
        return new AdobevallasRiport(adobevallas(), ceg1, ceg2, maganember1(), maganember2());
    }
}
