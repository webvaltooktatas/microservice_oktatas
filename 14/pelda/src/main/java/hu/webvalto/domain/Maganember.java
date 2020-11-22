package hu.webvalto.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@NamedQuery(name = "Maganember.akinekTobbABeveteleMintEgyMillio",
        query = "SELECT me FROM Maganember me WHERE me.evesBevetel > 1000000")
@Entity
public class Maganember implements Adozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 4, max = 10)
    private String nev;
    @NotBlank
    @Size(min = 8, max = 11)
    private String adoszam;
    private Long evesBevetel;
    private Long evesKiadas;
    @ManyToOne
    private Cim cim;
    @Transient
    @Value("${maganember.adokulcs}")
    private Double adokulcs;

    public Maganember() {
    }

    public Maganember(@NotBlank @Size(min = 4, max = 10) String nev, @NotBlank @Size(min = 8, max = 11) String adoszam) {
        this.nev = nev;
        this.adoszam = adoszam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getAdokulcs() {
        return adokulcs;
    }

    public void setAdokulcs(Double adokulcs) {
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
