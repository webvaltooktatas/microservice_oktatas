package hu.webvalto.config;

import hu.webvalto.domain.Cim;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "maganember")
public class MaganemberProperties {
    private String nev;
    private String adoszam;
    private Cim cim;
    private Long evesBevetel;
    private Long evesKiadas;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getAdoszam() {
        return adoszam;
    }

    public void setAdoszam(String adoszam) {
        this.adoszam = adoszam;
    }

    public Cim getCim() {
        return cim;
    }

    public void setCim(Cim cim) {
        this.cim = cim;
    }

    public Long getEvesBevetel() {
        return evesBevetel;
    }

    public void setEvesBevetel(Long evesBevetel) {
        this.evesBevetel = evesBevetel;
    }

    public Long getEvesKiadas() {
        return evesKiadas;
    }

    public void setEvesKiadas(Long evesKiadas) {
        this.evesKiadas = evesKiadas;
    }
}
