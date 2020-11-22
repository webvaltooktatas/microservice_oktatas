package hu.webvalto.config;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Cim;
import hu.webvalto.domain.Maganember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private CegProperties cegProperties;

    @Autowired
    private MaganemberProperties maganemberProperties;

    //Meghivodik az init metodusa a Ceg Bean-nek a bean inicializalasakor
    @Bean(initMethod = "init")
    public Ceg ceg1(Cim cim, Maganember maganember1) {
        cim.setVaros(cegProperties.getCim().getVaros());
        cim.setUtca(cegProperties.getCim().getUtca());
        cim.setHazszam(cegProperties.getCim().getHazszam());
        cim.setIranyitoszam(cegProperties.getCim().getIranyitoszam());
        Ceg ceg = new Ceg(cegProperties.getNev(), cim, cegProperties.getAdoszam(), maganember1);
        ceg.setEvesBevetel(cegProperties.getEvesBevetel());
        ceg.setEvesKiadas(cegProperties.getEvesKiadas());
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
        Maganember maganember = new Maganember(maganemberProperties.getNev(), maganemberProperties.getAdoszam());
        cim.setVaros(maganemberProperties.getCim().getVaros());
        cim.setUtca(maganemberProperties.getCim().getUtca());
        cim.setHazszam(maganemberProperties.getCim().getHazszam());
        cim.setIranyitoszam(maganemberProperties.getCim().getIranyitoszam());
        maganember.setCim(cim);
        maganember.setEvesBevetel(maganemberProperties.getEvesBevetel());
        maganember.setEvesKiadas(maganemberProperties.getEvesKiadas());
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
