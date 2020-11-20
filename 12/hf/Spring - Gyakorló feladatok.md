# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Készítsünk egy logger-t ami minden végpont meghívásakor ki logolja, hogy melyik metódus lett meghívva és milyen paraméterekkel. A logolási szint legyen **DEBUG**.
Amennyiben a vezérlőben kivételt dobunk, úgy **ERROR** szinten logoljuk az okát.

A logger példányt injektáljuk. ne manuálisan hozzuk létre! A végpontok logolásához használjunk Aspect-et.

Implementáljuk, hogy minden beérkező kérésnél olvassa ki a correlation id-t a kérés fejlécéből, s tároljuk az MDC-ben.
Amennyiben nem létezett, úgy generáljunk egyet mi magunk.

A logger legyen módosítva, hogy minden log bejegyzéshez írja ki a correlation id-t is.

#### Technikai leírás
HTTP Kérés fejlécben az "X-Correlation-Id" kulcs alatt keressük a korrelációs id-t, amennyiben nem volt úgy generáljunk egyet és adjuk hozzá a kérés fejlécéhez.

