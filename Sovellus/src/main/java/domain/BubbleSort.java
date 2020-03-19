package domain;

public class BubbleSort implements Sort {

    private int[] array;
    private int repeats;

    public BubbleSort(int[] array, int repeats) {
        this.array = array;
        this.repeats = repeats;
    }

    @Override
    public long sort() {
        long startTime = System.nanoTime();
        for (int i = 0; i < this.array.length - 1; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (this.array[j] > this.array[j+1]) {
                    int tmp = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = tmp;
                }
            }
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
