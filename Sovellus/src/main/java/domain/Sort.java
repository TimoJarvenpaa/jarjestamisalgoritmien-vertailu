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
}
