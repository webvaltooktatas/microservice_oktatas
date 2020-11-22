# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Módosítsuk a legutóbbi házi feladatunkat a következők szerint:
- Maganember, Ceg és Cim legyenek entitások (nem kell többé Bean-ként kezelni)
- Készítsünk repository-t a magánember és cég entitásokhoz, melyek biztosítják a CRUD műveleteket
- Egészísük ki a Repository-kat hogy támogassa a következő lekérdezéseket:
    - Összes magánember/cég akinek van évesbevetele 
    - Összes magánember / cég összes éves bevétele 
    - Összes magánember / cég összes éves kiadása 
- Írjuk át az alkalmazást, hogy ezeket az új Repositorykat használja a kiszolgálásra
- Alakítsuk át az adobevallasRiport szolgáltatást, hogy a Repository-kat használja most már