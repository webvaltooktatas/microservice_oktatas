package hu.webvalto.demo;

import hu.webvalto.demo.domain.Ceg;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Ceg1 letrehozasa");
        Ceg ceg1 = (Ceg) context.getBean("ceg1");
        System.out.println(ceg1);
        System.out.println("Ceg1 nev es hazszam valtas");
        ceg1.getCim().setHazszam("54");
        ceg1.setNev("Ceg3");
        System.out.println(ceg1);
        System.out.println("Ceg2 letrehozasa");
        Ceg ceg2 = (Ceg) context.getBean("ceg2");
        System.out.println(ceg2);
        System.out.println("Ceg1 letrehozasa");
        ceg1 = (Ceg) context.getBean("ceg1");
        System.out.println(ceg1);
        context.registerShutdownHook();
    }
}

