package hu.webvalto.demo.domain;

public class Ceg {

    private String nev;
    private Cim cim;
    private String leiras;
    private String tipus;

    public Ceg(String nev, Cim cim) {
        this.nev = nev;
        this.cim = cim;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Cim getCim() {
        return cim;
    }

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

    public void nyitas() {
        System.out.println("Ez a ceg letrehozasra kerult");
    }

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
