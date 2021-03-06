package hu.webvalto.domain;

public class Maganember implements Adozo {
    private String nev;
    private String adoszam;
    private Long evesBevetel;
    private Long evesKiadas;
    private Cim cim;

    public Maganember(String nev, String adoszam) {
        this.nev = nev;
        this.adoszam = adoszam;
    }

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

    public Cim getCim() {
        return cim;
    }

    public void setCim(Cim cim) {
        this.cim = cim;
    }

    public double getAdokulcs() {
        return 0.27;
    }

    @Override
    public String toString() {
        return "Maganember{" +
                "nev='" + nev + '\'' +
                ", adoszam='" + adoszam + '\'' +
                ", evesBevetel=" + evesBevetel +
                ", evesKiadas=" + evesKiadas +
                ", cim=" + cim +
                '}';
    }

    private void init() {
        System.out.println("Maganember letre lett hozva!");
    }
}
