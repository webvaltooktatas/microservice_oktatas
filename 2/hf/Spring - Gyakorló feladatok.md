# Spring - Gyakorló feladatok

## 1.feladat

### Készítsünk egy Spring-es alkalmazást, mely elvégzi az adóbevallásunkat. Az alkalmazás mind magánembernek, mind cégnek képesnek kell lennie elkészíteni az adóbevallást.

Hozzunk létre két magánembert és két céget:
* A magánembernek legyen
    * **Kötelezően:**  neve, adószáma
    * **Opcionálisan:** éves bevétel, éves kiadás, címe
* Cégnek legyen
    *  **Kötelezően:**  neve, székhely címe, adószáma, tulajdonos (magánember)
    * **Opcionálisan:** éves bevétel, éves kiadás, 

* A létrehozott magánember és cégnek is a Cím egy új bean legyen ahol:
    * **Opcionálisan:** város, utca, házszám, irányítószám

Hozzunk létre egy (service) bean-t is, mely az adóbevallását fogja elkészíteni:
* Támogassa mind magánembernek, mind cégeknek kiszámítani a befizetendő adót:
    * **Magánembernek:** (éves kiadás - éves bevétel) * 0.27
    * **Cégnek:** (éves kiadás - éves bevétel) * 0.35
    * **A service kezelje megfelelően ha valamelyik mezőnek nincs értéke (bevétel / kiadás), negativ összeg esetén legyen 0.**

Hozzunk létre egy másik (service) bean-t, melyet meghívva az összes magánembernek és cégnek kiszámolja a befizetendő adót, összesíti és irassuk ki a konzolra (**System.out.println**):
* _XY. magánember adatai: (név, cim, stb.)_
* _XY. magánember befizetett: X Ft_
* _XY. cég adatai: (név, cim, stb.)_
* _XY. cég befizetett: X Ft_
* _Összesen befizetett adók magánemberek által: X Ft_
* _Összesen befizetett adók cégek által: X Ft_
* _Összesen befizetett adók: X Ft_

_**XY**: A magánember/cég neve_
###### Főprogram
* Hívjuk meg a service-t ami kiszámolja a befizentedő adót minden embernek és cégnek

#### Technikai részletek
* Irassuk ki a konzolra (**System.out.println**) a következő eseményeket:
    * Bean létrehozása
    * Adóbevallás elkészítése a(z) XY.-nak
    * Adóbevallás riport meghívásra került
* Az egyik magánembernek legyen címe, és kitöltve az opcionális mezők, a másiknál ne legyen bevétele.
* Az egyik cégnek legyen több kiadása, mint bevétele, a másiknál legyen több a bevétel mint a kiadás és mindkét cégnek legyen a székhely kitöltve
* Egyelőre a mind az emberek, mind a cégek bean-ként legyenek létrehozva és függőségként legyenek a kötelező mezők beinjektálva / létrehozva.
* A bean metadatok megadásához használjunk Java konfigurációt!
* Ahol lehet függőségi injekciót használjunk!
* A Cím bean legyen minden alkalommal újra példányosítva amikor függőségként betöltésre kerül!
* A magánemberek és cégek tárolják az alkalmazás futásának a végéig a bennük tárolt adatokat, ne kerüljenek újrapéldányosításra!


## 2.feladat

### Készítsük a fenti alkalmazást, de Spring Boot alapokon!
A **MainApplication.java** adjuk meg a következő Bean definiciot:

    @Bean
    public ApplicationRunner runner(ApplicationContext ctx, AdobevallasRiport adobevallasRiport) {
        return args -> {
            System.out.println("Spring Boot applikacio elindult");
            adobevallasRiport.lekerdezes();
        };
    }
    
Ez automatikusan meg fog hívódni amikor a Spring Boot alkalmazás inicializációja befejeződött, s meghívja az _adobevallasRiport.lekerdezes()_ metódust!

#### Technikai részletek
* Amennyiben nem tettük korábban, úgy engedélyezzük a komponens szkennelést (component scan) is!
* A Cím Bean **ne** Java configban legyen megadva, hanem használjuk a megfelelő sztereotípia (stereotype) annotációt!
* Hasonlóan a (adóbevallás és adóbevallást összesítő) két service bean **se** Java configban legyen definiálva, hanem a megfelelő sztereotípia annotációt használjuk!
