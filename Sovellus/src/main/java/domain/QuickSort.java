package domain;

public class QuickSort extends Sort {

    /**
     * @param array järjestettävä taulukko
     * @param repeats taulukon järjestyskertojen lukumäärä
     */
    public QuickSort(int[] array, int repeats) {
        super(array, repeats);
    }

    /**
     * Metodi järjestää taulukon käyttäen pikajärjestämistä ja mittaa
     * järjestämiseen kuluneen ajan nanosekunteina
     *
     * @return taulukon järjestämiseen kulunut aika nanosekunteina
     */
    @Override
    public long sort() {
        long startTime = System.nanoTime();
        quickSort(this.array, 0, this.array.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Metodi suorittaa pikajärjestämisen rekursiivisesti käyttämällä
     * osituksessa jakoalkiona kolmen mediaania (eng. median-of-three).
     *
     * @param array järjestettävä taulukko
     * @param leftIndex järjestettävän taulukon vasemmanpuoleinen indeksi
     * @param rightIndex järjestettävän taulukon oikeanpuoleinen indeksi
     */
    public void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int pivot = medianOfThree(array, leftIndex, rightIndex);
        int index = partition(array, leftIndex, rightIndex, pivot);
        quickSort(array, leftIndex, index - 1);
        quickSort(array, index, rightIndex);
    }

    /**
     * Metodi suorittaa pikajärjestämisessä tarvittavan osituksen annetun
     * jakoalkion suhteen.
     *
     * @param array järjestettävä taulukko
     * @param leftIndex osituksessa käytettävä vasemmanpuoleinen indeksi
     * @param rightIndex osituksessa käytettävä oikeanpuoleinen indeksi
     * @param pivot jakoalkio, jonka suhteen ositus tehdään
     * @return
     */
    public int partition(int[] array, int leftIndex, int rightIndex, int pivot) {
        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    /**
     * Metodi selvittää kolmen mediaanin ensimmäisen, keskimmäisen ja viimeisen
     * indeksin joukosta ja palauttaa tämän arvon.
     *
     * @param array taulukko, josta kolmen mediaani lasketaan
     * @param leftIndex (osa)taulukon vasemmanpuoleisin/ensimmäinen indeksi
     * @param rightIndex (osa)taulukon oikeanpuoleisin/viimeinen indeksi
     * @return kolmen mediaani
     */
    public int medianOfThree(int[] array, int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;

        if (array[middleIndex] < array[leftIndex]) {
            swap(array, leftIndex, middleIndex);
        }

        if (array[rightIndex] < array[leftIndex]) {
            swap(array, leftIndex, rightIndex);
        }

        if (array[middleIndex] < array[rightIndex]) {
            swap(array, middleIndex, rightIndex);
        }

        return array[rightIndex];
    }
}
