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
        countingSort();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa laskemisjärjestämisen parametrina annetulle taulukolle
     */
    public void countingSort() {
        int k = maxValue(this.array);
        int[] count = new int[k + 1];

        for (int i = 0; i < this.array.length; i++) {
            count[this.array[i]]++;
        }

        int total = 0;
        for (int i = 0; i <= k; i++) {
            int tmp = count[i] + total;
            count[i] = total;
            total = tmp;
        }

        int[] output = new int[this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            output[count[this.array[i]]] = this.array[i];
            count[this.array[i]]++;
        }

        this.array = output;
    }
}
