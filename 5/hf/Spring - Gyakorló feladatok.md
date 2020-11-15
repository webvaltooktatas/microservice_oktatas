# Spring - Gyakorló feladatok

## 1.feladat

### Egészítsük ki az előző házi feladatunk (kiinduló feladat) megoldását az alkalmazásunk teszteléséhez szükséges unit teszt osztályainkkal. 

A cél, hogy minden funkció külön-külön tesztelve legyen és biztosítsa a helyes működést és az integritását a funkcióknak.

Egészítsük ki a kódot pár ellenőrzéssel, pl.: volt-e megadva adózó, valamint tesztelésnél lehessen megadni az adókulcsot.


## 2.feladat

### Egészítsük ki az előző házi feladatunkat. Legyen webes alkalmazás és a főoldalt megnyitva (URI: "/") üdvözöljön minket. Számoljuk ki és irassuk a böngészőben ki a cégek és a magánemberek befizetendő adóját. (hozzunk létre külön végpontot)

Módosítani kell a riport szervízt hogy csak magánember vagy csak cégek adóbevallását számolja ki.
Létre kell hozni az adóbevallás controllert hogy a végpontokat meghívhassuk. (lásd előadás)

Írjunk integrációs teszteket ami teszteli a főoldalt valamint a magánszemélyek és cégek adóbevallását (lehet egyszerűsíteni a szövegen: Név + befizetendő adó).

URI-k:
- Főoldal URI: **www.localhost:8081/**
- Magánszemélyek bevallás URI: **www.localhost:8081/maganszemelyek**
- Cégek bevallás URI: **www.localhost:8081/cegek**

Az alkalmazás a **8081**-es porton fusson!