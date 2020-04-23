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
        bubbleSort(this.array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Kuplajärjestämisen suorittava metodi.
     * @param array järjestettävä taulukko
     */
    public void bubbleSort(int[] array) {
        boolean isSwapped;
        for (int i = 0; i < array.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSwapped = true;
                }
            }
            if (isSwapped == false) {
                break;
            }
        }
    }
}
