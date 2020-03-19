package domain;

public class InsertionSort implements Sort {

    private int[] array;
    private int repeats;

    public InsertionSort(int[] array, int repeats) {
        this.array = array;
        this.repeats = repeats;
    }

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

    public long getAverageTime() {
        long totalTime = 0;
        int[] unsortedArray = this.array.clone();
        for (int i = 0; i < this.repeats; i++) {
            totalTime += sort();
            this.setArray(unsortedArray);
        }
        return totalTime / repeats;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    
    

}
