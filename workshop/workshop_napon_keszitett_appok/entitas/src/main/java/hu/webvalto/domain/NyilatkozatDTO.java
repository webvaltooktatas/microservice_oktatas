package hu.webvalto.domain;

public class NyilatkozatDTO {
    private String id;
    private String leiras;
    private String tartalom;
    private Long bevetel;
    private Long kiadas;
    private Long adozo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public Long getBevetel() {
        return bevetel;
    }

    public void setBevetel(Long bevetel) {
        this.bevetel = bevetel;
    }

    public Long getKiadas() {
        return kiadas;
    }

    public void setKiadas(Long kiadas) {
        this.kiadas = kiadas;
    }

    public Long getAdozo() {
        return adozo;
    }

    public void setAdozo(Long adozo) {
        this.adozo = adozo;
    }
}
