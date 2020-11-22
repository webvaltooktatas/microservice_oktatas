package hu.webvalto.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ceg implements Adozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 4, max = 20)
    @Column(name = "cegnev")
    private String nev;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "szekhely_id")
    private Cim szekhely;
    @Size(min = 8, max = 11)
    @NotBlank
    private String adoszam;
    @NotNull
    @ManyToOne
    private Maganember tulajdonos;
    private Long evesBevetel;
    private Long evesKiadas;
    @Transient
    @Value("${ceg.adokulcs}")
    private Double adokulcs;


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

    public Double getAdokulcs() {
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

    public void setAdokulcs(Double adokulcs) {
        this.adokulcs = adokulcs;
    }
}

