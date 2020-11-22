package hu.webvalto.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document
public class Nyilatkozat {
    @MongoId
    private String id;
    private String tipus;
    @DBRef
    private Nyilatkozat kapcsolodoNyilatkozat;
    private Adozo nyilatkozatTevo;
    private LocalDate nyilatkozatTevesIdeje;
    private Long nyilatkozatTevoEvesBevetele;
    private Long nyilatkozatTevoEvesKiadasa;
    private Double nyilatkozatAdozandoOsszeg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Nyilatkozat getKapcsolodoNyilatkozat() {
        return kapcsolodoNyilatkozat;
    }

    public void setKapcsolodoNyilatkozat(Nyilatkozat kapcsolodoNyilatkozat) {
        this.kapcsolodoNyilatkozat = kapcsolodoNyilatkozat;
    }

    public Adozo getNyilatkozatTevo() {
        return nyilatkozatTevo;
    }

    public void setNyilatkozatTevo(Adozo nyilatkozatTevo) {
        this.nyilatkozatTevo = nyilatkozatTevo;
    }

    public LocalDate getNyilatkozatTevesIdeje() {
        return nyilatkozatTevesIdeje;
    }

    public void setNyilatkozatTevesIdeje(LocalDate nyilatkozatTevesIdeje) {
        this.nyilatkozatTevesIdeje = nyilatkozatTevesIdeje;
    }

    public Long getNyilatkozatTevoEvesBevetele() {
        return nyilatkozatTevoEvesBevetele;
    }

    public void setNyilatkozatTevoEvesBevetele(Long nyilatkozatTevoEvesBevetele) {
        this.nyilatkozatTevoEvesBevetele = nyilatkozatTevoEvesBevetele;
    }

    public Long getNyilatkozatTevoEvesKiadasa() {
        return nyilatkozatTevoEvesKiadasa;
    }

    public void setNyilatkozatTevoEvesKiadasa(Long nyilatkozatTevoEvesKiadasa) {
        this.nyilatkozatTevoEvesKiadasa = nyilatkozatTevoEvesKiadasa;
    }

    public Double getNyilatkozatAdozandoOsszeg() {
        return nyilatkozatAdozandoOsszeg;
    }

    public void setNyilatkozatAdozandoOsszeg(Double nyilatkozatAdozandoOsszeg) {
        this.nyilatkozatAdozandoOsszeg = nyilatkozatAdozandoOsszeg;
    }

    @Override
    public String toString() {
        return "Nyilatkozat{" +
                "id='" + id + '\'' +
                ", tipus='" + tipus + '\'' +
                ", kapcsolodoNyilatkozat=" + kapcsolodoNyilatkozat +
                ", nyilatkozatTevo=" + nyilatkozatTevo +
                ", nyilatkozatTevesIdeje=" + nyilatkozatTevesIdeje +
                ", nyilatkozatTevoEvesBevetele=" + nyilatkozatTevoEvesBevetele +
                ", nyilatkozatTevoEvesKiadasa=" + nyilatkozatTevoEvesKiadasa +
                ", nyilatkozatAdozandoOsszeg=" + nyilatkozatAdozandoOsszeg +
                '}';
    }
}
