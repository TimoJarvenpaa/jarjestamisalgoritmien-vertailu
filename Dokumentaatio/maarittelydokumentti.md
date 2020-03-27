# Määrittelydokumentti

## Aihe ja työn laajuus

Harjoitustyöni tavoitteena on toteuttaa Javalla sovellus, jonka avulla on mahdollista vertailla eri järjestämisalgoritmien aikavaativuuksia mittaamalla kokonaisulukuja satunnaisessa järjestyksessä sisältävän taulukon järjestämiseen käytettyä aikaa. Tarkoituksenani on luoda sovellukselle yksinkertainen graafinen käyttöliittymä, jonka kautta käyttäjä voi valita useampia järjestämisalgoritmeja, joille vertailu ja tulosten visualisointi suoritetaan.

## Käytettävät algoritmit ja tietorakenteet

Lähtökohtana on toteuttaa itse ainakin seuraavat järjestämisalgoritmit:

* Lisäysjärjestäminen (Insertion sort)
* Kuplajärjestäminen (Bubble sort)
* Lomitusjärjestäminen (Merge sort)
* Pikajärjestäminen (Quicksort) (*Median-of-three)
* Laskemisjärjestäminen (Counting sort)
* Kantalukujärjestäminen (Radix sort)
* Introsort
* Timsort

Edellä mainittujen algoritmien toteutuksen jälkeen tarkoituksenani on tarvittaessa lisätä sovellukseen valittavaksi muitakin järjestämisalgoritmeja, kuten esimerkiksi kekojärjestämisen, ja niiden mahdollisesti tarvitsemat tietorakenteet. En osaa vielä arvioida kuinka paljon aikaa pelkkien perustoiminnallisuuksien toteutus vie, joten en tiedä vielä, montako erilaista järjestämisalgoritmia lopullisessa sovelluksessa on valittavissa.

Edellä listatut algoritmit edustavat erilaisia lähestymistapoja järjestämiseen, joten niiden toteutus ja suorituskykyvertailu voi osoittautua mielenkiintoiseksi.

## Ohjelman käyttämät syötteet ja toiminta

Tarkoituksena on, että ennen vertailtavien järjestämisalgoritmien valintaa käyttäjä valitsee järjestettettävän taulukon koon, jonka jälkeen tarvittava taulukko luodaan satunnaisgeneroimalla riittävä määrä kokonaislukuja. Satunnaislukujen generointi ei ole harjoitustyöni keskeinen tavoite, joten ainakin aluksi käytän siinä apuna jotain valmista kirjastoa. Aikavaativuutta sovellus estimoi laskemalla algoritmin järjestämiseen käyttämää aikaa. Suorituksenaikaisen vaihtelun ja epätarkkuuden vähentämiseksi jokainen algoritmi suorittaa alkuperäisen taulukon järjestämisen useampaan kertaan ja lopulliseksi arvioksi käytetystä ajasta valitaan suoritusaikojen keskiarvo. En osaa vielä sanoa, onko tämä täysin järkevä ratkaisu suurempien taulukoiden järjestämisen kannalta. Tavoitteena on myös, että sovellus visualisoi vertailuista saadut tulokset jollain yksinkertaisella tavalla.

## Tavoitteena olevat aikavaativuudet

|Algoritmi|Keskimääräinen tapaus|Pahin tapaus|
|---|---|---|
|Lisäysjärjestäminen|O(n²)|O(n²)|
|Kuplajärjestäminen|O(n²)|O(n²)|
|Lomitusjärjestäminen|O(n log n)|O(n log n)|
|Pikajärjestäminen|O(n log n)|O(n²)|
|Laskemisjärjestäminen|O(n + r)|O(n + r)|
|Kantalukujärjestäminen|O(n * k/d)|O(n * k/d)|
|Introsort|O(n log n)|O(n log n)|
|Timsort|O(n log n)|O(n log n)|

## Lähteet

[Wikipedia, Sorting algorithm](https://en.wikipedia.org/wiki/Sorting_algorithm)