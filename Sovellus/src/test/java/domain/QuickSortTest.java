package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class QuickSortTest {

    QuickSort quick;
    RandomArrayGenerator rand;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        arrayToSort = rand.getRandomArray(1000);
        copiedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
        quick = new QuickSort(copiedArray, 1);

    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        Arrays.sort(arrayToSort);
        int[] expectedResult = arrayToSort;

        quick.sort();
        int[] result = quick.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
    
    @Test
    public void medianOfThreeReturnsCorrectValue() {
        int[] arr = {7,2,9,5,4};
        int result = quick.medianOfThree(arr, 0, 4);
        assertEquals(7, result);
    }
}