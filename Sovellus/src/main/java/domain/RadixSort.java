package domain;

public class RadixSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public RadixSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen kantalukujärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        radixSort();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa kantalukujärjestämisen käyttäen apuna
     * laskemisjärjestämistä taulukon vaiheittaisessa järjestämisessä edeten
     * vähiten merkitsevästä numerosta seuraavaksi vähiten merkitsevään
     * numeroon.
     */
    public void radixSort() {
        int max = maxValue(this.array);

        for (int exp = 1; (max / exp) > 0; exp *= 10) {
            digitBasedCountingSort(exp);
        }
    }

    /**
     * Metodi suorittaa laskemisjärjestämisen parametrina annetulle taulukolle
     * toisena parametrina annetun merkitsevän numeron position mukaan.
     *
     * @param exp merkitsevän numeron positio kymmenjärjestelmässä (1, 10,
     * 100...)
     */
    public void digitBasedCountingSort(int exp) {
        int[] count = new int[10];

        for (int i = 0; i < this.array.length; i++) {
            count[(this.array[i] / exp) % 10]++;
        }

        int total = 0;
        for (int i = 0; i < 10; i++) {
            int tmp = count[i] + total;
            count[i] = total;
            total = tmp;
        }

        int[] output = new int[this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            output[count[(this.array[i] / exp) % 10]] = this.array[i];
            count[(this.array[i] / exp) % 10]++;
        }

        this.array = output;
    }

}
