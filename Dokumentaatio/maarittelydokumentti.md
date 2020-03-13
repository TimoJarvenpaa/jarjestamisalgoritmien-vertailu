# Määrittelydokumentti

## Aihe ja työn laajuus

Harjoitustyöni tavoitteena on toteuttaa Javalla sovellus, jonka avulla on mahdollista vertailla eri järjestämisalgoritmien aikavaativuuksia mittaamalla satunnaisessa järjestyksessä olevan taulukon järjestämiseen käytettyä aikaa. Tarkoituksenani on luoda sovellukselle yksinkertainen graafinen käyttöliittymä, jonka kautta käyttäjä voi valita vähintään kaksi järjestämisalgoritmia, joille vertailu ja tulosten visualisointi suoritetaan.

## Käytettävät algoritmit ja tietorakenteet

Lähtökohtana on toteuttaa itse ainakin seuraavat järjestämisalgoritmit:

* Lisäysjärjestäminen
* Kuplajärjestäminen
* Lomitusjärjestäminen
* Pikajärjestäminen

Edellä mainittujen algoritmien toteutuksen jälkeen tarkoituksenani on lisätä sovellukseen valittavaksi muitakin järjestämisalgoritmeja, kuten esimerkiksi kekojärjestämisen, ja niiden mahdollisesti tarvitsemat tietorakenteet. En osaa vielä arvioida kuinka paljon aikaa pelkkien perustoiminnallisuuksien toteutus vie, joten en tiedä vielä, montako erilaista järjestämisalgoritmia lopullisessa sovelluksessa on valittavissa.

Valitsin edellä listatut algoritmit sovelluksen lähtökohdaksi, sillä lisäys- ja kuplajärjestämisellä sekä toisaalta lomitus- ja pikajärjestämisellä on keskenään samanlaiset keskimääräiset aikavaativuudet, minkä vuoksi on mielenkiintoista nähdä ilmenevätkö nämä teoreettiset yhtäläisyydet myös itse toteutetuilla algoritmeilla.

## Ohjelman käyttämät syötteet ja toiminta

Tarkoituksena on, että ennen vertailtavien järjestämisalgoritmien valintaa käyttäjä valitsee järjestettettävän taulukon koon, jonka jälkeen tarvittava taulukko luodaan satunnaisgeneroimalla riittävä määrä kokonaislukuja. Satunnaislukujen generointi ei ole harjoitustyöni keskeinen tavoite, joten ainakin aluksi käytän siinä apuna jotain valmista kirjastoa. Aikavaativuutta sovellus estimoi laskemalla algoritmin järjestämiseen käyttämää aikaa. Suorituksenaikaisen vaihtelun ja epätarkkuuden vähentämiseksi jokainen algoritmi suorittaa alkuperäisen taulukon järjestämisen useampaan kertaan ja lopulliseksi arvioksi käytetystä ajasta valitaan suoritusaikojen keskiarvo. En osaa vielä sanoa, onko tämä täysin järkevä ratkaisu suurempien taulukoiden järjestämisen kannalta. Tavoitteena on myös, että sovellus visualisoi vertailuista saadut tulokset jollain yksinkertaisella tavalla.

## Tavoitteena olevat aikavaativuudet

* Lisäysjärjestäminen (O(n²))
* Kuplajärjestäminen (O(n²))
* Lomitusjärjestäminen (O(n log n))
* Pikajärjestäminen (O(n log n))

## Lähteet

[Wikipedia, Sorting algorithm](https://en.wikipedia.org/wiki/Sorting_algorithm)