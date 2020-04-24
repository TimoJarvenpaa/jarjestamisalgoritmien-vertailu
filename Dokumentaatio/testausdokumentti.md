# Testausdokumentti

## Yksikkötestaus

Testikattavuusraportti voidaan luoda Sovellus-hakemistossa komennolla:
```
./gradlew jacocoTestReport
```
Raportti löytyy tämän jälkeen tiedostosta `build/reports/jacoco/test/html/index.html`

Sovelluksen järjestämisalgoritmeista vastaaville domain-pakkauksen luokille kirjoitetut testit varmistavat, että järjestämisalgoritmit toimivat oikein. Tämä on toteutettu kunkin algoritmin tapauksessa luomalla satunnainen vähintään tuhannen kokonaisluvun taulukko, jossa luvut kuuluvat välille yhdestä tuhanteen. Taulukosta on tehty kopio, jonka algoritmi järjestää. Alkuperäisen taulukon järjestää Javan Arrays.sort()-metodi. Järjestettyjä taulukoita verrataan lopuksi toisiinsa, jolloin mahdolliset virheet järjestämisalgoritmin toteutuksessa tulevat suurella todennäköisyydellä ilmi. Myös osa algoritmien käyttämistä apumetodeista on erikseen yksikkötestattu, sillä järjestämisen lopputuloksen oikeellisuuden tarkistaminen toimii lähinnä integraatiotestinä apumetodien yhteistoiminnalle, eikä auta löytämään mahdollista vian aiheuttajaa.

Käyttöliittymästä vastaava ui-pakkauksen App-luokka on jätetty testikattavuusraportin ulkopuolelle. Käyttöliittymätestaus on tehty manuaalisesti kokeilemalla kaikkia valittavissa olevia toimintoja.

## Suorituskykytestaus

Sovellus on rakennettu suorituskykytestausta varten, joten kaikki suorituskykyyn liittyvät testit ovat helposti toistettavissa käyttöliittymän kautta valitsemalla sopivat asetukset. Jokaisella vertailukerralla järjestettävä taulukko luodaan valittujen asetusten rajoissa satunnaisesti, joten yksittäisiä mittauskertoja ei voi varsinaisesti verrata toisiinsa. Useampia mittauksia tehdessä algoritmien suorituskyvyt suhteessa toisiinsa ilmenevät kuitenkin mittaustuloksista.

Sovelluksen asetuksiin kuuluu järjestettävän taulukon koon ja sen sisältämien lukujen arvovälin valinta sekä saman taulukon uudelleenjärjestämiskertojen lukumäärä. Uudelleenjärjestämisen ideana on, että jokainen algoritmi järjestää taulukon useammin kuin kerran ja lopullinen mittaustulos on mitattujen aikojen mediaani. Mediaania käytettäessä mahdolliset ohjelman suorituksen aikana tapahtuvat javan JIT-käännökseen tai roskienkeräämiseen liittyvät hidastukset eivät vaikuta lopulliseen aikaan yhtä merkittävästi kuin esimerkiksi keskiarvoa käytettäessä. Uudelleenjärjestäminen on toteutettu niin, että jokaisen järjestämiskerran päätteeksi taulukko palautetaan alkuperäiseen järjestämättömään tilaan.

Seuraavien mittaustulosten on määrä havainnollistaa mahdollisia eroja algoritmien aikavaativuuksissa eri pituisilla taulukoilla ja järjestettävien lukujen eri arvoväleillä. Mittaukset on tehty käyttäen kymmentä toistoa/uudelleenjärjestystä per algoritmi (repeats=10). Kaksi ensimmäistä taulukkoa sisältävät järjestämiseen kuluneita aikoja nanosekunteina ja kaksi jälkimmäistä millisekunteina. Lukujen arvoväli vaikuttaa lähinnä laskemis- ja kantalukujärjestämisen toimintaan, mutta muissa tapauksissa ylimääräiset mittauskerrat antavat luotettavamman kuvan algoritmin yleisestä aikavaativuudesta.

### n = 100, (ns)

|Arvoväli|1-10|1-100|1-1000|1-10000|
|---|---|---|---|---|
|Lisäysjärjestäminen|10 009|12 763|9602|10 033|
|Kuplajärjestäminen|31 710|33 694|35 981|29 362|
|Lomitusjärjestäminen|20 288|20 649|24 371|19 162|
|Pikajärjestäminen|10 607|20 295|11 994|13 288|
|Laskemisjärjestäminen|5338|13 537|28 209|245 763|
|Kantalukujärjestäminen|24 116|12 042|24 229|36 327|
|Kekojärjestäminen|15 395|5093|17 919|15 387|
|Introsort|5262|1875|7598|5890|

### n = 1000, (ns)

|Arvoväli|1-10|1-100|1-1000|1-10000|
|---|---|---|---|---|
|Lisäysjärjestäminen|740 931|811 667|824 492|956 845|
|Kuplajärjestäminen|3 369 700|2 695 632|1 329 859|2 594 093|
|Lomitusjärjestäminen|122 205|120 419|104 565|126 417|
|Pikajärjestäminen|53 833|81 885|83 653|80 573|
|Laskemisjärjestäminen|8142|5286|7497|27 675|
|Kantalukujärjestäminen|55 912|55 531|73 603|75 295|
|Kekojärjestäminen|115 434|116 341|186 630|98 448|
|Introsort|35 689|52 343|57 587|57 706|

### n = 10 000, (ms)

|Arvoväli|1-10|1-100|1-1000|1-10000|
|---|---|---|---|---|
|Lisäysjärjestäminen|12.63|13.71|14.13|14.07|
|Kuplajärjestäminen|94.91|101.59|101.90|102.77|
|Lomitusjärjestäminen|0.61|0.72|0.81|0.85|
|Pikajärjestäminen|0.38|0.56|0.70|0.80|
|Laskemisjärjestäminen|0.03|0.03|0.03|0.05|
|Kantalukujärjestäminen|0.23|0.34|0.45|0.56|
|Kekojärjestäminen|0.67|0.87|0.89|0.90|
|Introsort|0.34|0.46|0.55|0.65|

### n = 100 000, (ms)

|Arvoväli|1-10|1-100|1-1000|1-10000|
|---|---|---|---|---|
|Lisäysjärjestäminen|1258.25|1382.69|1385.82|1383.78|
|Kuplajärjestäminen|12 425.84|12 521.73|12 574.06|12 595.88|
|Lomitusjärjestäminen|6.81|8.09|9.18|10.15|
|Pikajärjestäminen|4.00|5.41|6.81|8.66|
|Laskemisjärjestäminen|0.33|0.23|0.30|0.46|
|Kantalukujärjestäminen|2.36|3.35|4.31|5.45|
|Kekojärjestäminen|7.86|9.79|11.24|11.93|
|Introsort|3.84|5.09|6.35|7.92|