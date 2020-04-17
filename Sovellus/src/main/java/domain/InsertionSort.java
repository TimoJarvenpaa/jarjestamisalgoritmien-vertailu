package domain;

public class InsertionSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
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
        insertionSort(this.array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi järjestää annetun taulukon käyttäen lisäysjärjestämistä
     *
     * @param array järjestettävä taulukko
     */
    public void insertionSort(int[] array) {
        int i = 1;
        while (i < array.length) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j, j - 1);
                j--;
            }
            i++;
        }
    }

    /**
     * Metodi järjestää annetussa taulukossa parametreina saatujen indeksien
     * välisen alueen käyttäen lisäysjärjestämistä
     *
     * @param array taulukko, jossa järjestäminen tapahtuu
     * @param leftIndex järjestettävän osuuden ensimmäinen indeksi
     * @param rightIndex järjestettävän osuuden viimeinen indeksi
     */
    public void insertionSort(int[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            int key = array[i];
            int j = i;

            while (j > leftIndex && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }
}
