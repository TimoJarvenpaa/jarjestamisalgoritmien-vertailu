package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class HeapSortTest {

    HeapSort heap;
    RandomArrayGenerator rand;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        arrayToSort = rand.getRandomArray(1000);
        copiedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
        heap = new HeapSort(copiedArray, 1);

    }
    
    @Test
    public void afterBuildMaxHeapRootIsCorrect() {
        heap.buildMaxHeap(copiedArray);
        int result = heap.getArray()[0];
        int expectedResult = heap.maxValue(copiedArray);
        
        assertEquals(expectedResult, result);
    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        Arrays.sort(arrayToSort);
        int[] expectedResult = arrayToSort;

        heap.sort();
        int[] result = heap.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
}