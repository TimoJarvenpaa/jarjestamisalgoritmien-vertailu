package domain;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class InsertionSortTest {

    InsertionSort insertion;
    RandomArrayGenerator rand;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        arrayToSort = rand.getRandomArray(1000);
        copiedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
        insertion = new InsertionSort(copiedArray, 1);

    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        Arrays.sort(arrayToSort);
        int[] expectedResult = arrayToSort;

        insertion.sort();
        int[] result = insertion.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
    
    @Test
    public void limitedInsertionSortWorksCorrectly() {
        int[] array = {13, 52, 73, 11, 3, 25};
        insertion.insertionSort(array, 1, 4);
        int[] expectedResult = {13, 3, 11, 52, 73, 25};
        assertTrue(Arrays.equals(expectedResult, array));
    }
}
