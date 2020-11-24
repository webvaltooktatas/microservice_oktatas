package hu.webvalto.elso;

import java.time.LocalDate;
import java.time.LocalTime;

public class Hello {
    private String nev;
    private LocalTime idopont;
    private String uzenet;

    public Hello(String nev, LocalTime idopont, String uzenet) {
        this.nev = nev;
        this.idopont = idopont;
        this.uzenet = uzenet;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public LocalTime getIdopont() {
        return idopont;
    }

    public void setIdopont(LocalTime idopont) {
        this.idopont = idopont;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }
}
