# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Futtassunk docker konténerben egy MySql adatbázist. Az alkalmazásunk kapcsolódjon a futtatott adatbázishoz. A kapcsolat adatait tároljuk az **application.properties**-ben s onnan legyen felolvasva a DBConfiguration-be amivel elkészítjük a **DataSource** bean-t amit használni fog a **JdbcTemplate**.

Ezután módosítsuk a Repository osztályainkat (amennyiben nincs új készítsük el őket), s immáron adatbázisba legyen mentve és kiolvasva a magánember és a cég.

Az adatbázis inicializációjához hozzunk létre egy komponenst ami elkészíti a Magánember és cég táblákat:
- Az oszlop nevek egyezzenek meg az objektumok neveivel a maganember eseten, mig a cegnel adatbazisban "cegnev" legyen az oszlopnak a neve.
- A típus megadásához is használjuk az mezők típusait
- Minden táblához legyen egy extra id mező, amit automatikusan generáltatunk az adatbázissal.

Inicializáció során hozzunk létre pár sort mindkettő táblába és nezzük meg az alkalmazás a REST api-n keresztül elvégzi-e a kívánt műveleteket.

Hozzunk létre mappereket, melyek a megfelelő objektumra mappelik az eredményt.