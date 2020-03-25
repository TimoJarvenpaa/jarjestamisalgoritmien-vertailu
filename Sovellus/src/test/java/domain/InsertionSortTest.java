package domain;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.RandomArrayGenerator;

public class InsertionSortTest {

    Sort insertion;
    RandomArrayGenerator r;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        r = new RandomArrayGenerator(1000);
        arrayToSort = r.getRandomArray();
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
}
