package domain;

public class BubbleSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public BubbleSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen kuplajärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        for (int i = 0; i < this.array.length - 1; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    int tmp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = tmp;
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
