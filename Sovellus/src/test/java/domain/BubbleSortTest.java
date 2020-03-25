package domain;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.RandomArrayGenerator;

public class BubbleSortTest {

    Sort bubble;
    RandomArrayGenerator r;
    int[] arrayToSort;
    int[] copiedArray;

    @Before
    public void setUp() {
        r = new RandomArrayGenerator(1000);
        arrayToSort = r.getRandomArray();
        copiedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
        bubble = new InsertionSort(copiedArray, 1);

    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        Arrays.sort(arrayToSort);
        int[] expectedResult = arrayToSort;

        bubble.sort();
        int[] result = bubble.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
}
