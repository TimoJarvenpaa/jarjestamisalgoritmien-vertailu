package domain;

public class HeapSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public HeapSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen kekojärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        heapSort(this.array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi järjestää koko annetun taulukon käyttäen kekojärjestämistä.
     *
     * @param array järjestettävä taulukko
     */
    public void heapSort(int[] array) {
        buildMaxHeap(array);
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            swap(array, i, 0);
            maxHeapify(array, i, 0);
        }
    }

    /**
     * Metodi rakentaa annetusta taulukosta maksimikeon.
     *
     * @param array taulukko, joka muunnetaan maksimikeoksi
     */
    public void buildMaxHeap(int[] array) {
        int heapSize = array.length;
        int start = (heapSize / 2) - 1;

        for (int i = start; i >= 0; i--) {
            maxHeapify(array, heapSize, i);
        }
    }

    /**
     * Metodi korjaa annetussa taulukossa alipuun rikkoutuneen kekoehdon
     * rekursiivisesti
     *
     * @param array taulukko, jota metodi käsittelee
     * @param heapSize keon koko
     * @param i juurisolmun indeksi
     */
    public void maxHeapify(int[] array, int heapSize, int i) {
        int max = i;
        int leftChildIndex = (2 * i) + 1;
        int rightChildIndex = (2 * i) + 2;

        if (leftChildIndex < heapSize && array[leftChildIndex] > array[max]) {
            max = leftChildIndex;
        }

        if (rightChildIndex < heapSize && array[rightChildIndex] > array[max]) {
            max = rightChildIndex;
        }

        if (max != i) {
            swap(array, max, i);
            maxHeapify(array, heapSize, max);
        }
    }

    /**
     * Metodi suorittaa annetussa taulukossa parametreina saatujen indeksien
     * väliin jäävälle osataulukolle kekojärjestämisen.
     *
     * @param array taulukko, jossa järjestäminen tapahtuu
     * @param leftIndex järjestettävän osataulukon vasemmanpuoleisin indeksi
     * @param rightIndex järjestettävän osataulukon oikeanpuoleisin indksi
     */
    public void limitedHeapSort(int[] array, int leftIndex, int rightIndex) {
        int heapSize = rightIndex - leftIndex;
        buildLimitedMaxHeap(array, leftIndex, rightIndex, heapSize);
        for (int i = heapSize; i >= 1; i--) {
            swap(array, leftIndex, leftIndex + i);
            limitedMaxHeapify(array, 1, i, leftIndex);
        }
    }

    /**
     * Metodi rakentaa annetussa taulukossa parametreina saatujen indeksien
     * väliin jäävästä osataulukosta maksimikeon
     *
     * @param array taulukko, jossa maksimikeko rakennetaan
     * @param leftIndex maksimikeoksi muutettavan osataulukon vasemmanpuoleisin
     * indeksi
     * @param rightIndex maksimikeoksi muutettavan osataulukon oikeanpuoleisin
     * indeksi
     * @param heapSize keon koko
     */
    public void buildLimitedMaxHeap(int[] array, int leftIndex, int rightIndex, int heapSize) {
        for (int i = heapSize / 2; i >= 1; i--) {
            limitedMaxHeapify(array, i, heapSize, leftIndex);
        }
    }

    /**
     * Metodi korjaa annetussa taulukossa olevan osataulukon muodostaman
     * mahdollisesti rikkoutuneen keon
     *
     * @param array taulukko, jossa keko korjataan
     * @param i juurisolmun indeksi
     * @param heapSize keon koko
     * @param leftIndex osataulukon vasemmanpuoleisin indeksi
     */
    public void limitedMaxHeapify(int[] array, int i, int heapSize, int leftIndex) {
        int temp = array[leftIndex + i - 1];
        // child index
        int cIndex;

        while (i <= heapSize / 2) {
            cIndex = 2 * i;

            if (cIndex < heapSize && array[leftIndex + cIndex - 1] < array[leftIndex + cIndex]) {
                cIndex++;
            }

            if (temp >= array[leftIndex + cIndex - 1]) {
                break;
            }

            array[leftIndex + i - 1] = array[leftIndex + cIndex - 1];
            i = cIndex;
        }
        array[leftIndex + i - 1] = temp;
    }

}
