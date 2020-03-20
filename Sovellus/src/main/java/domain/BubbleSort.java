package domain;

public class BubbleSort implements Sort {

    private int[] array;
    private int repeats;

    public BubbleSort(int[] array, int repeats) {
        this.array = array;
        this.repeats = repeats;
    }

    /**
     * Metodi järjestää taulukon käyttäen kuplajärjestämistä ja mittaa järjestämiseen kuluneen ajan nanosekunteina
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

    public long getAverageTime() {
        long totalTime = 0;
        int[] unsortedArray = new int[this.array.length];
        System.arraycopy(this.array, 0, unsortedArray, 0, this.array.length);
        for (int i = 0; i < this.repeats; i++) {
            totalTime += sort();
            this.restoreOriginalArray(unsortedArray);
        }
        return totalTime / repeats;
    }

    public int[] getArray() {
        return array;
    }

    public void restoreOriginalArray(int[] unsortedArray) {
        int[] copiedArray = new int[this.array.length];
        System.arraycopy(unsortedArray, 0, copiedArray, 0, unsortedArray.length);
        this.array = copiedArray;
    }
}
