package domain;

public class MergeSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public MergeSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen lomitusjärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        int[] tempArray = new int[this.array.length];
        mergeSort(this.array, tempArray, 0, this.array.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa varsinaisen lomitusjärjestämisen jakaen järjestettävän
     * taulukon kahtia, rekursiivisesti kutsuen itseään kunnes lopulta
     * järjestetyt puoliskot lomitetaan.
     *
     * @param array järjestettävä taulukko
     * @param tempArray lomitukseen käytettävä aputaulukko
     * @param leftStart järjestettävän taulukon ensimmäinen indeksi
     * @param rightEnd järjestettävän taulukon viimeinen indeksi
     */
    public void mergeSort(int[] array, int[] tempArray, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, tempArray, leftStart, middle);
        mergeSort(array, tempArray, middle + 1, rightEnd);
        merge(array, tempArray, leftStart, rightEnd);
    }

    /**
     * Metodi lomittaa annetun taulukon järjestyksessä olevat puoliskot.
     *
     * @param array lomitettava taulukko
     * @param tempArray lomituksessa käytettävä aputaulukko
     * @param leftStart lomitettavan taulukon ensimmäinen indeksi
     * @param rightEnd lomitettavan taulukon viimeinen indeksi
     */
    public void merge(int[] array, int[] tempArray, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        final int size = rightEnd - leftStart + 1;
        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (array[leftIndex] <= array[rightIndex]) {
                tempArray[index] = array[leftIndex];
                leftIndex++;
            } else {
                tempArray[index] = array[rightIndex];
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(array, leftIndex, tempArray, index, leftEnd - leftIndex + 1);
        System.arraycopy(array, rightIndex, tempArray, index, rightEnd - rightIndex + 1);
        System.arraycopy(tempArray, leftStart, array, leftStart, size);
    }
}
