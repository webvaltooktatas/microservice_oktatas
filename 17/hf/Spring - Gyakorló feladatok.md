# Spring - Gyakorló feladatok

## 1.feladat

### Leírás
Módosítsuk az alkalmazásunkat a következőképpen:
- Legyen egy Resource szerver
- Lokálban futtatott keycloak szerverhez csatlakozzon a token validációhoz
    - Segítség: https://github.com/jgrandja/spring-security-oauth-5-2-migrate/tree/master/keycloak
- A végpontok közül csak a következőek követeljenek meg OAuth tokent:
    - Magánember nyilatkozatainak a lekérése
    - Cég nyilatkozatainak a lekérése