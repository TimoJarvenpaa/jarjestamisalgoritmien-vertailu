package domain;

public class IntroSort extends Sort {

    private final InsertionSort is;
    private final HeapSort hs;
    private final QuickSort qs;

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public IntroSort(int[] array, int repeats) {
        super(array, repeats);
        this.is = new InsertionSort(array, 1);
        this.hs = new HeapSort(array, 1);
        this.qs = new QuickSort(array, 1);
    }

    /**
     * Metodi järjestää taulukon käyttäen IntroSort -järjestämisalgoritmia ja
     * mittaa järjestämiseen kuluneen ajan nanosekunteina.
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        int maxDepth = calculateMaxDepth(this.array.length) * 2;
        introSort(this.array, 0, this.array.length - 1, maxDepth);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi järjestää parametrina saadun taulukon käyttäen
     * IntroSort-järjestämisalgoritmia. IntroSort käyttää tiettyyn
     * rekursiosyvyyteen asti pikajärjestämistä, vaihtaen järjestystavan
     * kekojärjestämiseen, jos riittävä syvyys saavutetaan. Alle 16 alkion
     * osataulukot järjestetään käyttäen lisäysjärjestämistä.
     *
     * @param array järjestettävä taulukko
     * @param leftIndex järjestettävän taulukon vasemmanpuoleisin indeksi
     * @param rightIndex järjestettävän taulukon oikeinpuoleisin indeksi
     * @param maxDepth saavutettava rekursiosyvyys, jonka jälkeen
     * pikajärjestäminen vaihdetaan kekojärjestämiseen
     */
    public void introSort(int[] array, int leftIndex, int rightIndex, int maxDepth) {

        if (rightIndex - leftIndex > 16) {
            if (maxDepth == 0) {
                hs.limitedHeapSort(array, leftIndex, rightIndex);
                return;
            }

            if (leftIndex >= rightIndex) {
                return;
            }

            int pivot = qs.medianOfThree(array, leftIndex, rightIndex);
            int index = qs.partition(array, leftIndex, rightIndex, pivot);
            introSort(array, leftIndex, index - 1, maxDepth - 1);
            introSort(array, index, rightIndex, maxDepth - 1);

        } else {
            is.insertionSort(array, leftIndex, rightIndex);
        }

    }

    /**
     * Metodi laskee IntroSortin käyttämän maksimirekursiosyvyyden, jonka
     * jälkeen pikajärjestäminen vaihdetaan kekojärjestämiseen
     *
     * @param length järjestettävän taulukon pituus
     * @return rekursiosyvyys
     */
    public int calculateMaxDepth(int length) {
        int maxDepth = 1;
        double exp = 2.7182818284;
        double value = exp * exp;
        while (value < length) {
            maxDepth++;
            value *= exp;
        }
        return maxDepth;
    }
}
