# Testausdokumentti

## Yksikkötestaus

Testikattavuusraportti voidaan luoda Sovellus-hakemistossa komennolla:
```
./gradlew jacocoTestReport
```
Raportti löytyy tämän jälkeen tiedostosta `build/reports/jacoco/test/html/index.html`

Sovelluksen järjestämisalgortimeista vastaaville domain-pakkauksen luokille kirjoitetut testit varmistavat, että järjestämisalgoritmit toimivat oikein. Tämä on toteutettu kunkin algoritmin tapauksessa luomalla satunnainen tuhannen kokonaisluvun taulukko, jossa luvut kuuluvat välille yhdestä tuhanteen. Taulukosta on tehty kopio, jonka algoritmi järjestää. Alkuperäisen taulukon järjestää Javan Arrays.sort()-metodi. Järjestettyjä taulukoita verrataan lopuksi toisiinsa, jolloin mahdolliset virheet järjestämisalgoritmin toteutuksessa tulevat ilmi. Yksittäisiä apumetodeja ei ole erikseen yksikkötestattu, sillä järjestämisen oikeellisuuden tarkistaminen toimii integraatiotestinä mahdollisille apumetoideille algoritmista riippuen.

Käyttöliittymästä vastaava ui-pakkauksen App-luokka on jätetty testikattavuusraportin ulkopuolelle. Käyttöliittymätestaus on tehty manuaalisesti.

## Suorituskykytestaus

Sovellus on rakennettu suorituskykytestausta varten, joten kaikki testit ovat helposti toistettavissa käyttöliittymän kautta valitsemalla sopivat asetukset. Jokaisella vertailukerralla asetusten rajoissa satunnaisesti generoitu taulukko tekee eri mittauskertojen keskinäisen vertailun kyseenalaiseksi, mutta samoilla asetuksilla tehdyn useamman mittauskerran keskiarvo havainnollistaa kuitenkin algortimien merkittävimpiä eroja.

Sovelluksen asetuksiin kuuluu järjestettävän taulukon koon ja sen sisältämien lukujen arvovälin valinta sekä saman taulukon uudelleenjärjestämiskertojen lukumäärä. Uudelleenjärjestämisellä pyritään kompensoimaan mahdollisia algoritmin suorituksen aikaisia, sen toiminnasta riippumattomia, hidastuksia, kuten Javan roskienkerääjän ajoittaista aktivoitumista. Jos uudelleenjärjestyskertoja valitaan tehtäväksi 100, jokainen järjestämisalgoritmi tekee ajanmittauksen 100 kertaa ja lopullinen tulos on näiden mittauskertojen keskiarvo.

### Koeasetelma #1

|Taulukon koko|Toistojen määrä|Lukujen arvoväli|
|---|---|---|
|10 000|100|1 - 10 000|

|Algoritmi|mittaus #1|mittaus #2|mittaus #3|
|---|---|---|---|
|Lisäysjärjestäminen|14 293 180|14 552 940||
|Kuplajärjestäminen|106 215 931|105 219 346||
|Lomitusjärjestäminen|896 450|883 405||
|Pikajärjestäminen|828 431|831 516||
|Laskemisjärjestäminen|56 664|40 455||
|Kantalukujärjestäminen|537 359|444 738||

### Koeasetelma #2

|Taulukon koko|Toistojen määrä|Lukujen arvoväli|
|---|---|---|
|100|100|1 - 10 000|

|Algoritmi|mittaus #1|mittaus #2|mittaus #3|
|---|---|---|---|
|Lisäysjärjestäminen|7 384|||
|Kuplajärjestäminen|17 484|||
|Lomitusjärjestäminen|12 826|||
|Pikajärjestäminen|6 460|||
|Laskemisjärjestäminen|63 308|||
|Kantalukujärjestäminen|23 658|||

(Huom. Yllä olevat koeasetelmat ovat vasta hahmotelmia. Teen lopulliset mittaukset vasta sitten, kun loputkin vertailtavat järjestämisalgoritmit on toteutettu.)