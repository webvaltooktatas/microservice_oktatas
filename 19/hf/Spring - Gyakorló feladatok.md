# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Készítsünk két alkalmazást, mely improvizálni fogja a gondoltam egy számra játékot:

1. alkalmazás:
    - Ez az alkalmazás lesz a játék mester. Elindítja a játékot azzal hogy küld egy üzenetet a "jatek" nevu queue-ra. Az üzenet a következőt tartalmazza: "GondoltamEgySzamra".
    - A számot random generálja le: 1 és 10 között
    - Amennyiben a válaszban helytelen számot kap, úgy válaszoljon vissza egy "NEM"-el.
    - Amennyiben helyes, a válasz legyen: "IGEN"
2. alkalmazás:
    - Ez az alkalmazás lesz a játékos. Hallgatózik a "jatek" nevu queue-n, s amennyiben beerkezik az uzenet, hogy "GondoltamEgySzamra", akkor random generáljon egy számot  (1-10 között) és küldje vissza ugyanarra a címre ahonnan érkezett az előző.
    - A válasz adás előtt várjon 1 másodpercet.
    - Amennyiben a válasz "NEM", úgy generáljon egy új számot.

Mindkét alkalmazás logolja ki a másiktól kapott üzeneteket és hogy sikeres volt-e vagy sem.

Az alkalmazások kapcsolódjanak egy docker futtatott ActiveMQ-hoz:
- Az oktatás során ez a képfájl volt használva: https://hub.docker.com/r/rmohr/activemq

