package hu.webvalto.service;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import org.springframework.stereotype.Service;

@Service
public class AdobevallasRiport {
    private Adobevallas adobevallas;
    private Ceg ceg1;
    private Ceg ceg2;
    private Maganember maganember1;
    private Maganember maganember2;

    public AdobevallasRiport(Adobevallas adobevallas, Ceg ceg1, Ceg ceg2, Maganember maganember1, Maganember maganember2) {
        this.adobevallas = adobevallas;
        this.ceg1 = ceg1;
        this.ceg2 = ceg2;
        this.maganember1 = maganember1;
        this.maganember2 = maganember2;
    }

    public String lekerdezes() {
        StringBuilder adobevallasok = new StringBuilder("Adobevallas riport meghivasra kerult!");

        double maganEmber1Ado = adobevallas.befizetendoAdo(maganember1);
        double maganEmber2Ado = adobevallas.befizetendoAdo(maganember2);
        double ceg1Ado = adobevallas.befizetendoAdo(ceg1);
        double ceg2Ado = adobevallas.befizetendoAdo(ceg2);
        double osszesMaganemberAdo = maganEmber1Ado + maganEmber2Ado;
        double osszesCegAdo = ceg1Ado + ceg2Ado;
        double osszesAdo = osszesMaganemberAdo + osszesCegAdo;

        //Irassuk ki konzolra az informaciokat
        adobevallasok.append(maganember1.getNev() + " maganember adatai: " + maganember1.toString());
        adobevallasok.append(maganember1.getNev() + " maganember befizetett: " + maganEmber1Ado + " Ft");
        adobevallasok.append(maganember2.getNev() + " maganember adatai: " + maganember2.toString());
        adobevallasok.append(maganember2.getNev() + " maganember befizetett: " + maganEmber2Ado + " Ft");
        adobevallasok.append(ceg1.getNev() + " ceg adatai: " + ceg1.toString());
        adobevallasok.append(ceg1.getNev() + " ceg befizetett: " + ceg1Ado + " Ft");
        adobevallasok.append(ceg2.getNev() + " ceg adatai: " + ceg2.toString());
        adobevallasok.append(ceg2.getNev() + " ceg befizetett: " + ceg2Ado + " Ft");
        adobevallasok.append("Osszesen befizetett adok maganemberek altal: " + osszesMaganemberAdo + " Ft");
        adobevallasok.append("Osszesen befizetett adok cegek altal: " + osszesCegAdo + " Ft");
        adobevallasok.append("Osszesen befizetett adok: " + osszesAdo + " Ft");

        return adobevallasok.toString();
    }
}
