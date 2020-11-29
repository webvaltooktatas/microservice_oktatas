package hu.webvalto.domain;

import java.util.List;

public abstract class AdozoDTO {
    protected Long id;
    protected String nev;
    protected CimDTO cimDTO;
    protected String adoszam;
    protected Long adokulcs;
    protected List<NyilatkozatDTO> nyilatkozatDTOS;

    public Long getAdokulcs() {
        return adokulcs;
    }

    public void setAdokulcs(Long adokulcs) {
        this.adokulcs = adokulcs;
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

    public CimDTO getCim() {
        return cimDTO;
    }

    public void setCim(CimDTO cimDTO) {
        this.cimDTO = cimDTO;
    }

    public String getAdoszam() {
        return adoszam;
    }

    public void setAdoszam(String adoszam) {
        this.adoszam = adoszam;
    }

    public List<NyilatkozatDTO> getNyilatkozatDTOS() {
        return nyilatkozatDTOS;
    }

    public void setNyilatkozatDTOS(List<NyilatkozatDTO> nyilatkozatDTOS) {
        this.nyilatkozatDTOS = nyilatkozatDTOS;
    }
}
