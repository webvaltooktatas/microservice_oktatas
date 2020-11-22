package hu.webvalto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "demo")
public class Nyilatkozat {
    @Id
    private String id;
    private String nev;
    private String leiras;
    private LocalDate letrehozasDatuma;
    @DBRef
    private Maganember tulajdonos;
    @DBRef
    private Nyilatkozat alnyilatkozat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public LocalDate getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDate letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public Maganember getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(Maganember tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Nyilatkozat getAlnyilatkozat() {
        return alnyilatkozat;
    }

    public void setAlnyilatkozat(Nyilatkozat alnyilatkozat) {
        this.alnyilatkozat = alnyilatkozat;
    }

    @Override
    public String toString() {
        return "Nyilatkozat{" +
                "id='" + id + '\'' +
                ", nev='" + nev + '\'' +
                ", leiras='" + leiras + '\'' +
                ", letrehozasDatuma=" + letrehozasDatuma +
                ", tulajdonos=" + tulajdonos +
                ", alnyilatkozat=" + alnyilatkozat +
                '}';
    }
}
