package hu.webvalto.nyilatkozatok.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document(collection="nyilatkozat")
public class NyilatkozatV2  {
    @MongoId
    private String id;
    private String leiras;
    private String tartalom;
    private Long bevetel;
    private Long kiadas;
    private Long adozoEmber;
    private Long adozo;
    private String temp;

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

    public Long getAdozoEmber() {
        return adozoEmber;
    }

    public void setAdozoEmber(Long adozoEmber) {
        this.adozoEmber = adozoEmber;
    }

    public Long getAdozo() {
        return adozo;
    }

    public void setAdozo(Long adozo) {
        this.adozo = adozo;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
