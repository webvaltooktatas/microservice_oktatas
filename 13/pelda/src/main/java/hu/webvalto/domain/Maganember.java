package hu.webvalto.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Maganember implements Adozo {
    @NotBlank
    @Size(min = 4, max = 10)
    private String nev;
    @NotBlank
    @Size(min = 8, max = 11)
    private String adoszam;
    private Long evesBevetel;
    private Long evesKiadas;
    private Cim cim;
    @Value("${maganember.adokulcs}")
    private double adokulcs;

    public Maganember() {
    }

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
        return adokulcs;
    }

    public void setAdokulcs(double adokulcs) {
        this.adokulcs = adokulcs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maganember that = (Maganember) o;
        return Double.compare(that.adokulcs, adokulcs) == 0 &&
                Objects.equals(nev, that.nev) &&
                Objects.equals(adoszam, that.adoszam) &&
                Objects.equals(evesBevetel, that.evesBevetel) &&
                Objects.equals(evesKiadas, that.evesKiadas) &&
                Objects.equals(cim, that.cim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, adoszam, evesBevetel, evesKiadas, cim, adokulcs);
    }

    private void init() {
        System.out.println("Maganember letre lett hozva!");
    }
}
