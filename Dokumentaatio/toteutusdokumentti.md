# Toteutusdokumentti

## Ohjelman yleisrakenne

Sovellus generoi käyttöliittymässä määritettyjen asetusten mukaan satunnaisen kokonaislukutaulukon ja mittaa sen järjestämiseen kuluvaa aikaa eri järjestämisalgoritmien tapauksessa. Mittaukset toistetaan tarvittaessa alkuperäisellä taulukolla ja lopputuloksena ilmoitetaan mittauskertojen mediaani.

Ohjelman pakkausrakenteen muodostaa ui-, domain- ja util-pakkaukset. Ui-pakkauksessa on sovelluksen graafisesta käyttöliittymästä vastaava koodi, domain-pakkaus sisältää järjestämisalgoritmien toteutukset ja util-pakkauksessa on järjestettävien taulukoiden satunnaisgeneroinnista vastaava luokka.

Käyttöliittymän rakentamiseen on käytetty JavaFX-kirjaston komponentteja. Yksittäiset järjestämisalgoritmit on toteutettu niin, että kukin niistä perii _Sort_-yliluokan, joka sisältää mm. ajan mittaamiseen liittyviä metodeja mutta jokainen algoritmi korvaa yliluokan sort()-metodin omalla toteutuksellaan. Apumetodit, joita käyttää useampi kuin yksi järjestämisalgoritmi, on siirretty yliluokan vastuulle.

### Käytetyt algoritmit ja saavutetut aikavaativuudet


#### Lisäysjärjestäminen (Insertion sort)

* O(n²)
* Vaikka lisäysjärjestämisen keskimääräinen aikavaativuus on neliöllinen, soveltuu se suorituskykyvertailunkin perusteella hyvin pienten taulukoiden järjestämiseen

[Wikipedia, Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)

#### Kuplajärjestäminen (Bubble sort)

* O(n²)
* Kuplajärjestäminen ei sovellu käytännön sovelluksiin, mutta se toimii hyvänä vertailukohtana muille algoritmeille. Suorituskykyvertailussa kuplajärjestäminen osoittautuikin muutamia poikkeuksia lukuunottamatta hitaimmaksi algoritmiksi kaiken kokoisilla taulukoilla.

[Wikipedia, Bubble sort](https://en.wikipedia.org/wiki/Bubble_sort)

#### Lomitusjärjestäminen (Merge sort)

* O(n log(n))
* Suorituskykyvertailussa lomitusjärjestäminen toimi keskimäärin yhtä tehokkaasti kuin kekojärjestäminen, jolla on sama aikavaativuus. Lomitusjärjestäminen hävisi kuitenkin suorituskykyvertailussa pikajärjestämiselle.

[Wikipedia, Merge sort](https://en.wikipedia.org/wiki/Merge_sort)

#### Pikajärjestäminen (Quicksort)

* O(n²)
* Sovelluksen käyttämä pikajärjestämisalgoritmi käyttää jakoalkion/pivotin valitsemiseen kolmen mediaania. Vaikka pahimman tapauksen aikavaativuus onkin O(n²), suoriutuu algoritmi keskimäärin ajassa O(n log(n)).

[Wikipedia, Quicksort](https://en.wikipedia.org/wiki/Quicksort)

#### Laskemisjärjestäminen (Counting sort)

* O(n + k), missä k on järjestettävien lukujen arvoväli
* Tilanteissa, joissa järjestettävän taulukon koko ei ole huomattavasti pienempi kuin lukujen arvoväli laskemisjärjestämisen aikavaativuus on lineaarinen. Päinvastaisessa tapauksessa algoritmi taantuu arvovälin mukaiseksi aikavaativuudeksi. laskemisjärjestäminen toimii varsinkin suurempien taulukoiden tapauksessa huomattavasti nopeammin kuin muut sovelluksen algoritmit.

[Wikipedia, Counting sort](https://en.wikipedia.org/wiki/Counting_sort)

#### Kantalukujärjestäminen (Radix sort)

* Teoreettinen aikavaativuus O(n*w), missä w on suurimman järjestettävän luvun pituus
* Sovelluksen käyttämä kantalukujärjestäminen on toteutettu niin, että taulukko järjestetään numeropositio kerrallaan vähiten merkitsevästä numerosta alkaen käyttäen jokaisella kierroksella laskemisjärjestämistä. Laskemisjärjestämisen käyttämä kymmenen jakojäännösoperaatio ilmeisesti hidastaa algoritmin toimintaa ja se pärjäsikin suorituskykyvertailussa suurinpiirtein yhtä hyvin kuin O(n log(n))-algoritmit.

[Wikipedia, Radix sort](https://en.wikipedia.org/wiki/Radix_sort)
[GeeksforGeeks, Radix sort](https://www.geeksforgeeks.org/radix-sort/)

#### Kekojärjestäminen (Heap sort)

* O(n log(n))
* Sovelluksen kekojärjestäminen on toteutettu maksimikeon avulla. Koska kekoa ei tietorakenteena tarvittu luokan ulkopuolella, on kaikki keon rakentamiseen liittyvät metodit toteutettu HeapSort-luokan sisällä ja ne tehdään syötteenä saatua taulukoa muokkaamalla. Kekojärjestämisen hyvä puoli on, että sen pahimman tapauksen aikavaativuus on O(n log(n)).

[Wikipedia, Heapsort](https://en.wikipedia.org/wiki/Heapsort)
[TutorialHorizon, Heap sort](https://algorithms.tutorialhorizon.com/heap-sort-java-implementation/)

#### Introsort

* O(n log(n))
* Hybridijärjestämisalgoritmina introsort yhdistelee pika-, keko- ja lisäysjärjestämisen parhaita puolia. Introsort toimii aluksi kuten pikajärjestäminen ja sovelluksen toteutus hyödyntääkin samaa kolmen mediaania käyttävää pikajärjestämistä. Järjestettävän taulukon koon perusteella lasketaan ennen järjestämisen aloittamista pikajärjestämisen rekursiolle maksimisyvyys. Jos maksimisyvyys saavutetaan, osataulukossa pikajärjestäminen vaihdetaan kekojärjestämiseen, joka takaa O(n log(n)) aikavaativuuden. Mikäli järjestettävän osataulukon pituus on alle 16, se järjestetään käyttäen lisäysjärjestämistä. Suorituskykyvertailussa ainoastaan laskemisjärjestäminen pärjäsi varsinkin suurilla taulukoilla paremmin kuin introsort, mutta laskemisjärjestämisen käyttörajoitteet huomioon ottaen introsort vaikutti sovelluksen järjestämisalgoritmeista kaikkein käyttökelpoisimmalta vaihtoehdolta.

[Wikipedia, Introsort](https://en.wikipedia.org/wiki/Introsort)
[GeeksforGeeks, IntroSort](https://www.geeksforgeeks.org/introsort-or-introspective-sort/)

### Suorituskykyvertailu

Katso [testausdokumentti](testausdokumentti.md).