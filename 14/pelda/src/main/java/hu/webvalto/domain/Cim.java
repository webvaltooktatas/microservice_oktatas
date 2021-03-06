package hu.webvalto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String varos;
    private String utca;
    private String hazszam;
    private String iranyitoszam;

    public Cim() {
    }

    public Cim(String varos, String utca, String hazszam, String iranyitoszam) {
        this.varos = varos;
        this.utca = utca;
        this.hazszam = hazszam;
        this.iranyitoszam = iranyitoszam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public String getHazszam() {
        return hazszam;
    }

    public void setHazszam(String hazszam) {
        this.hazszam = hazszam;
    }

    public String getIranyitoszam() {
        return iranyitoszam;
    }

    public void setIranyitoszam(String iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    @Override
    public String toString() {
        return "Cim{" +
                "varos='" + varos + '\'' +
                ", utca='" + utca + '\'' +
                ", hazszam='" + hazszam + '\'' +
                ", iranyitoszam='" + iranyitoszam + '\'' +
                '}';
    }
}
