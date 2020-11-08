package hu.webvalto.domain;

public class Ceg implements Adozo {
    private String nev;
    private Cim szekhely;
    private String adoszam;
    private Maganember tulajdonos;
    private Long evesBevetel;
    private Long evesKiadas;

    public Ceg(String nev, Cim szekhely, String adoszam, Maganember tulajdonos) {
        this.nev = nev;
        this.szekhely = szekhely;
        this.adoszam = adoszam;
        this.tulajdonos = tulajdonos;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Cim getSzekhely() {
        return szekhely;
    }

    public void setSzekhely(Cim szekhely) {
        this.szekhely = szekhely;
    }

    public String getAdoszam() {
        return adoszam;
    }

    public void setAdoszam(String adoszam) {
        this.adoszam = adoszam;
    }

    public Maganember getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(Maganember tulajdonos) {
        this.tulajdonos = tulajdonos;
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

    public double getAdokulcs() {
        return 0.35;
    }

    @Override
    public String toString() {
        return "Ceg{" +
                "nev='" + nev + '\'' +
                ", szekhely=" + szekhely +
                ", adoszam='" + adoszam + '\'' +
                ", tulajdonos=" + tulajdonos +
                ", evesBevetel=" + evesBevetel +
                ", evesKiadas=" + evesKiadas +
                '}';
    }

    private void init() {
        System.out.println("Ceg letre lett hozva!");
    }
}
