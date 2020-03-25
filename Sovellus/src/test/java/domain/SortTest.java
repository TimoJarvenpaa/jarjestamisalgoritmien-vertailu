package domain;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.RandomArrayGenerator;

public class SortTest {

    Sort sort;
    RandomArrayGenerator r;
    int[] originalArray;
    int[] restoredArray;

    @Before
    public void setUp() {
        r = new RandomArrayGenerator(1000);
        originalArray = r.getRandomArray();
        sort = new Sort(originalArray, 2);

    }

    @Test
    public void arrayDoesntReferToTheSameObjectOnNextRepeat() {
        sort.getAverageTime();
        restoredArray = sort.getArray();
        assertTrue(originalArray != restoredArray);
    }
}