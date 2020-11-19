# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Hozzunk létre egy komponenst melyben tárolni fogunk Magánember és Cég objektumokat. Módosítsuk az AdobevallasController-t, hogy megvalósítsa a CRUD (Létrehozás - Olvasás - Módosítás - Törlés) műveleteket mind Magánember, mind Cég objektumok menedzselésére:
#### CRUD példa
- Létrehozás: 
    - URI:   "/maganember"
    - HTTP metódus: POST
    - Elvárt paraméterek: Magánember létrehozásához szükséges adatok (JSON)
    - Válasz: "Létrehozva" (plain text, egyszerű szöveg)
    - Státuszkód: 201
    - Létrehozott magánember objektum tárolása  fent említett komponensben
    
- Olvasás: 
    - URI:   "/maganember/<id>"
    - HTTP metódus: GET
    - Elvárt paraméterek: nincs
    - Válasz: Magánember objektum (JSON)
    - Státuszkód: 200
    - Létező magánember visszaadása id alapján
    
- Módosítás: 
    - URI:   "/maganember/<id>"
    - HTTP metódus: PUT
    - Elvárt paraméterek: Módosított magánember (JSON)
    - Válasz: "Módosítva" (plain text, egyszerű szöveg)
    - Státuszkód: 200
    - Létező magánember módosítása id alapján
    
- Törlés: 
    - URI:   "/maganember/<id>"
    - HTTP metódus: DELETE
    - Elvárt paraméterek: nincs
    - Válasz: nincs
    - Státuszkód: 204
    - Létező magánember törlése id alapján
  
#### Validáció
- A fent leírtak szerint fogadjon el kérés médiatípusokat és készítse el a szükséges választ és állítsa be a kívánt médiatípust.
- A belépési pontokon ahol id-t adhatunk át, validáljuk hogy az átadott id pozitív szám.
- A magánember és cég objektumokon validáljuk hogy a kötelező mezők kitöltésre kerültek-e, valamint nem üres értékekkel 
- Az adószámnak 8 és 11 karakter közé kell esnie
- A névnek 4 karakternél hosszabbnak kell lennie
  
#### Hibakezelés
- Amennyiben az erőforrás nem található, úgy térjen vissza a HTTP NOT FOUND válasszal.
- Amennyiben validációs hiba keletkezett, úgy kezeljük egyedileg és adjunk át a válaszban egy extra kulcs érték párt:
    - "validacios hiba": "igen"

#### Tesztelés
- Írjunk egységtesztet a validációs megkötések tesztelésére.
- Írjunk integrációs teszteket a fenti CRUD műveletek tesztelésére
- Írjunk integrációs teszteket a fenti CRUD műveletek hibakezelésének tesztelésére

#### Technikai kiegészítés
- A médiatípus lekérdezése és meghatározása a "Content-type" fejléc attributúm segítségével oldható meg.