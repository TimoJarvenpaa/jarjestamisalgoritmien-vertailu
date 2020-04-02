package domain;

public class CountingSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public CountingSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen laskemisjärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        this.setArray(countingSort(this.array));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa laskemisjärjestämisen parametrina annetulle taulukolle
     * ja palauttaa uuden järjestetyn taulukon.
     *
     * @param array järjestettävä taulukko
     * @return järjestetty taulukko
     */
    public int[] countingSort(int[] array) {
        int k = maxValue(array);
        int[] count = new int[k + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        int total = 0;
        for (int i = 0; i <= k; i++) {
            int tmp = count[i] + total;
            count[i] = total;
            total = tmp;
        }

        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            output[count[array[i]]] = array[i];
            count[array[i]]++;
        }

        return output;
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
