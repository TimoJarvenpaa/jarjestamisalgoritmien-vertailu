package domain;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class MergeSortTest {

    Sort merge;
    RandomArrayGenerator rand;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        arrayToSort = rand.getRandomArray(1000);
        copiedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
        merge = new MergeSort(copiedArray, 1);

    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        Arrays.sort(arrayToSort);
        int[] expectedResult = arrayToSort;

        merge.sort();
        int[] result = merge.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
}
