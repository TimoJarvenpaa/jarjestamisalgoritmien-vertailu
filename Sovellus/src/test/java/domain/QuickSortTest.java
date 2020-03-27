package domain;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class QuickSortTest {

    Sort quick;
    RandomArrayGenerator rand;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        arrayToSort = rand.getRandomArray();
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
}