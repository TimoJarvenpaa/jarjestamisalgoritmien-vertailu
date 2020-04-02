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
        radixSort(this.array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa kantalukujärjestämisen käyttäen apuna
     * laskemisjärjestämistä taulukon vaiheittaisessa järjestämisessä edeten
     * vähiten merkitsevästä numerosta seuraavaksi vähiten merkitsevään
     * numeroon.
     *
     * @param array järjestettävä taulukko
     */
    public void radixSort(int[] array) {
        int max = maxValue(array);

        for (int exp = 1; (max / exp) > 0; exp *= 10) {
            digitBasedCountingSort(array, exp);
        }
    }

    /**
     * Metodi suorittaa laskemisjärjestämisen parametrina annetulle taulukolle
     * toisena parametrina annetun merkitsevän numeron position mukaan.
     *
     * @param array järjestettävä taulukko
     * @param exp merkitsevän numeron positio kymmenjärjestelmässä (1, 10,
     * 100...)
     */
    public void digitBasedCountingSort(int[] array, int exp) {
        int[] count = new int[10];

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        int total = 0;
        for (int i = 0; i < 10; i++) {
            int tmp = count[i] + total;
            count[i] = total;
            total = tmp;
        }

        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            output[count[(array[i] / exp) % 10]] = array[i];
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

}
