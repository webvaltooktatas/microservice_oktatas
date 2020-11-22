# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Hozzunk létre adóbevallás nyilatkozatokat és tároljuk mongoDB-ben.

A nyilatkozatok a következő képpen nézzenek ki:
- Id: string
- tipus: string (pl.: adóbevallás)
- kapcsolodoNyilatkozat: Nyilatkozat
- nyilatkozatTevo: Maganember  | Ceg
- nyilatkozatTevesIdeje: Date
- nyilatkozatTevoEvesBevetele: Integer
- nyilatkozatTevoEvesKiadasa: Integer
- nyilatkozatTevoAdozandoOsszeg: Integer

Minden alkalommal amikor futtatjuk az adobevallasRiport szolgáltatást, készítsen egy nyilatkozatot, melyben tárolja a fenti adatokat.

Minden nyilatkozat egy új nyilatkozatként kerüljön elmentésre és amennyiben volt korábbi nyilatkozat, úgy a kapcsolodoNyilatkozat mezőben az legyen tárolva referenciaként.

Készítsünk egy új végpontot, ahol lekérdezhető a nyilatkozatai az magánembernek vagy cégnek:
- **/maganember/{id}/nyilatkozatok**
- **/ceg/{id}/nyilatkozatok**

Készítsünk egy új végpontot, ahol generáltathatunk egy új riportot és tárolásra kerül a nyilatkozat:
- **/maganember/{id}/adobevallas**
- **/ceg/{id}/adobevallas**