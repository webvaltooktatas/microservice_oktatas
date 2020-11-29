package hu.webvalto.bevallaslekerdezes.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ceg extends Adozo {
    @ManyToOne
    @JoinColumn(name="maganember_id")
    private Maganember tulajdonos;

}
