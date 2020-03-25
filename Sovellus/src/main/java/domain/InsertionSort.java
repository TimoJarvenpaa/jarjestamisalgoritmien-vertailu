package domain;

public class InsertionSort extends Sort {

    public InsertionSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen lisäysjärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
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
}
