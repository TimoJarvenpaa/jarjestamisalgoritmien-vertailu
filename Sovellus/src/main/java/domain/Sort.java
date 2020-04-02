package domain;

public class Sort {

    protected int[] array;
    protected int repeats;

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public Sort(int[] array, int repeats) {
        this.array = array;
        this.repeats = repeats;
    }

    /**
     * Tavallinen getterimetodi yksikkötestien käyttöön.
     *
     * @return järjestämisessä käytettävä taulukko
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Eri järjestämisalgoritmit on toteutettu omina aliluokkinaan, jotka
     * korvaavat tämän toteutuksen omalla metodillaan.
     *
     * @return tätä paluuarvoa ei käytetä
     */
    public long sort() {
        return 0;
    }

    /**
     * Metodi laskee taulukon järjestämiseen kuluneen keskimääräisen ajan
     * nanosekunteina. Sama taulukko järjestetään uudelleen
     * repeats-oliomuuttujassa määritellyn toistokertojen lukumäärän mukaisesti.
     * Jokaisen järjestämiskerran jälkeen taulukko palautetaan alkuperäiseen
     * järjestämättömään tilaan.
     *
     * @return keskimääräinen taulukon järjestämiseen kulunut aika
     * nanosekunteina
     */
    public long getAverageTime() {
        long totalTime = 0;
        int[] unsortedArray = new int[this.array.length];
        System.arraycopy(this.array, 0, unsortedArray, 0, this.array.length);
        for (int i = 0; i < this.repeats; i++) {
            totalTime += sort();
            this.restoreOriginalArray(unsortedArray);
        }
        return totalTime / repeats;
    }

    /**
     * Metodi asettaa järjestettäväksi taulukoksi sille syötteenä annetun
     * järjestämättömän taulukon, josta luodaan kopio, joka ei viittaa
     * alkuperäiseen taulukkoon
     *
     * @param unsortedArray järjestämätön taulukko
     */
    public void restoreOriginalArray(int[] unsortedArray) {
        int[] copiedArray = new int[this.array.length];
        System.arraycopy(unsortedArray, 0, copiedArray, 0, unsortedArray.length);
        this.array = copiedArray;
    }

    /**
     * Metodi vaihtaa kahden alkion paikan annetussa taulukossa.
     *
     * @param array taulukko, jossa vaihto tulee tehdä
     * @param index1 ensimmäisen vaihdettavan alkion indeksi
     * @param index2 toisen vaihfettavan alkion indeksi
     */
    public void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    
    /**
     * Metodi palauttaa parametrina annetun kokonaislukutaulukon suurimman
     * arvon.
     *
     * @param array taulukko, josta suurin arvo etsitään
     * @return taulukon suurin arvo
     */
    public int maxValue(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
