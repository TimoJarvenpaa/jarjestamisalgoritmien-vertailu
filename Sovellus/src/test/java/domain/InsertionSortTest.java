package domain;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.RandomArrayGenerator;

public class InsertionSortTest {

    InsertionSort insertion;
    RandomArrayGenerator r;
    int[] arrayToSort;

    @Before
    public void setUp() {
        r = new RandomArrayGenerator(1000);
        arrayToSort = r.getRandomArray();
        insertion = new InsertionSort(arrayToSort.clone(), 1);

    }

    @Test
    public void randomArrayIsSortedCorrectly() {
        int[] expectedResult = arrayToSort.clone();
        Arrays.sort(expectedResult);

        insertion.sort();
        int[] result = insertion.getArray();

        assertTrue(Arrays.equals(expectedResult, result));
    }
}
