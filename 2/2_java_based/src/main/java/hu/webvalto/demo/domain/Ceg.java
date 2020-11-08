package hu.webvalto.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Ceg {

    private String nev;
    private Cim cim;
    private String leiras;
    private String tipus;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Cim getCim() {
        return cim;
    }

    @Autowired
    public void setCim(Cim cim) {
        this.cim = cim;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @PostConstruct
    public void nyitas() {
        System.out.println("Ez a ceg letrehozasra kerult");
    }

    @PreDestroy
    public void felszamolas() {
        System.out.println("Ez a ceg felszamolasra kerult");
    }

    @Override
    public String toString() {
        return "Ceg{" +
                "nev='" + nev + '\'' +
                ", cim=" + cim +
                ", leiras='" + leiras + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}
