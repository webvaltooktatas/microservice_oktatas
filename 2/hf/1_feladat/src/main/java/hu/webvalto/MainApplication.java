package hu.webvalto;

import hu.webvalto.config.AppConfig;
import hu.webvalto.service.AdobevallasRiport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        //Spring Context inicializalas
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //AdobevallasRiport bean peldany kerese a Spring Context-tol
        AdobevallasRiport adobevallasRiport = (AdobevallasRiport) context.getBean("adobevallasRiport");
        //Adobevallas riport elkeszitese
        adobevallasRiport.lekerdezes();
        //Beregisztralja a shutdownHook monitort: amennyiben definialtunk "destroy-method" callback metodust,
        //igy azok meghivasra fognak kerulni amikor az alkalmazas veget er
        context.registerShutdownHook();
    }
}
