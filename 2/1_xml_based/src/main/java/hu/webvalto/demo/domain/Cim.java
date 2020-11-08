package hu.webvalto.demo.domain;

public class Cim {

    private String varos;
    private String utca;
    private String hazszam;

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


    @Override
    public String toString() {
        return "Cim{" +
                "varos='" + varos + '\'' +
                ", utca='" + utca + '\'' +
                ", hazszam='" + hazszam + '\'' +
                '}';
    }
}
