package domain;

public class InsertionSort implements Sort {

    private int[] array;
    private int repeats;

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public InsertionSort(int[] array, int repeats) {
        this.array = array;
        this.repeats = repeats;
    }

    /**
     * Metodi järjestää taulukon käyttäen lisäysjärjestämistä ja mittaa järjestämiseen kuluneen ajan nanosekunteina
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        int i = 1;
        while (i < this.array.length) {
            int j = i;
            while (j > 0 && this.array[j - 1] > this.array[j]) {
                int tmp = this.array[j];
                this.array[j] = this.array[j - 1];
                this.array[j - 1] = tmp;
                j--;
            }
            i++;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi laskee taulukon järjestämiseen kuluneen keskimääräisen ajan nanosekunteina. Sama taulukko järjestetään uudelleen repeats-oliomuuttujassa
     * määritellyn toistokertojen lukumäärän mukaisesti. Jokaisen järjestämiskerran jälkeen taulukko palautetaan alkuperäiseen järjestämättömään tilaan.
     * @return keskimääräinen taulukon järjestämiseen kulunut aika nanosekunteina
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

    public int[] getArray() {
        return array;
    }

    /**
     * Metodi asettaa järjestettäväksi taulukoksi sille syötteenä annetun järjestämättömän taulukon, josta luodaan kopio,
     * joka ei viittaa alkuperäiseen taulukkoon
     * @param unsortedArray järjestämätön taulukko
     */
    public void restoreOriginalArray(int[] unsortedArray) {
        int[] copiedArray = new int[this.array.length];
        System.arraycopy(unsortedArray, 0, copiedArray, 0, unsortedArray.length);
        this.array = copiedArray;
    }
    
    

}
