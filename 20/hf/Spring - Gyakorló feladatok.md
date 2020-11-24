# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Készítsünk két alkalmazást.

**1.alkalmazás**
Az első alkalmazáson engedélyezzük az Actuatorok használatát és **csak** a következő actuator végpontok legyenek engedélyezve:
- health
- szolgaltatasok
    
Az utóbbi végpont nem létezik, mi magunk hozzuk létre és a következő szolgáltatások legyenek listázva:
- jövőbe látás
- főzés
- mosogatás

Hozzunk létre egy Hello nevezetű objektumot és irassuk ki az alkalamazás főoldalára de JSON formátumban.

A Hello objektum szerkezete:
 - nev: string
 - idopont: localtime
 - uzenet: string
 
A főoldalt meghívva készítsük el a Hello objektumot a következő módszerrel:
- Random válasszon a következő nevek közül: vándor, idegen, barát
- Az időpont az aktuális dátum legyen
- Az üzenet pedig a következő: Hello {nev}, eme csodás napon.

A főoldal bárki számára elérhető legyen

Az actuator végpontok legyenek védve HTTP BASIC auth-al:
- Név: test
- Jelszó: test

Port: 8081

**2. alkalmazás**
A második alkalmazás az első alkalmazásnak fogja meghívni bizonyos végpontjait.

A második alkalmazás minden végpontja legyen védett és követeljen meg authentikációt.
- Technikai információ: 
    -  Használjuk a Spring Boot Security-t és a beépített login felületet.
        -   A testreszabást végezzük el konfiguráción keresztül:
                - spring.security.user.name=admin
                - spring.security.user.password=admin

A második alkalmazás főoldalát megnyitva (login után), küldjünk egy GET kérést az első alkalmazás főoldalára.
Itt nem lesz szükségünk még semmilyen autentikációra az első alkalmazás esetén, mivel alapértelmezetten engedélyezett a főoldal megnyitása.
A második alkalmazásnál az "/info" végpontot meghívva, küldjünk egy GET kérést az első alkalmazásnak, ahol a "/actuator" végpontot szeretnénk megnyitni.
Ezen kérések esetén már szükségünk lesz, hogy a hívásnál HTTP Basic authentikációs adatokat is küldjünk különben nem lesz jogunk megnyitni azt az oldalt.

Az "/info" utána részt kezelje az alkalmazás dinamikusan és küldje el az első alkalmazásnak:
- "/info/**health**" ----->  "/actuator/**health**"
- "/info/**szolgaltatasok**" ----->  "/actuator/**szolgaltatasok**"

Port: 8080
