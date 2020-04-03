package domain;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import util.RandomArrayGenerator;

public class SortTest {

    Sort sort;
    RandomArrayGenerator rand;
    int[] originalArray;
    int[] restoredArray;

    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(1000);
        originalArray = rand.getRandomArray(1000);
        sort = new Sort(originalArray, 2);

    }

    @Test
    public void arrayDoesntReferToTheSameObjectOnNextRepeat() {
        sort.getAverageTime();
        restoredArray = sort.getArray();
        assertTrue(originalArray != restoredArray);
    }
}