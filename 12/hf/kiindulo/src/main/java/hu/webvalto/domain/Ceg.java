package hu.webvalto.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Ceg implements Adozo {
    @NotBlank
    @Size(min = 4, max = 10)
    private String nev;
    @NotNull
    private Cim szekhely;
    @Size(min = 8, max = 11)
    @NotBlank
    private String adoszam;
    @NotNull
    private Maganember tulajdonos;
    private Long evesBevetel;
    private Long evesKiadas;
    @Value("${ceg.adokulcs}")

    private double adokulcs;

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
        return adokulcs;
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

    public void setAdokulcs(double adokulcs) {
        this.adokulcs = adokulcs;
    }
}

