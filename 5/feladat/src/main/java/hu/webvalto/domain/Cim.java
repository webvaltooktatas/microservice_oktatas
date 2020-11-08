package hu.webvalto.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Scope("prototype")
@Component
public class Cim {
    private String varos;
    private String utca;
    private String hazszam;
    private String iranyitoszam;

    public Cim() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Cim letrehozasra kerult");
    }

    public Cim(String varos, String utca, String hazszam, String iranyitoszam) {
        this.varos = varos;
        this.utca = utca;
        this.hazszam = hazszam;
        this.iranyitoszam = iranyitoszam;
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
