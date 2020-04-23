package domain;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void maxValueReturnsCorrectValue() {
        int[] array = {49, 12, 22, 65, 94, 7};
        int result = sort.maxValue(array);
        assertEquals(94, result);
    }
    
    @Test
    public void minValueReturnsCorrectValue() {
        int[] array = {49, 12, 22, 65, 94, 7};
        int result = sort.minValue(array);
        assertEquals(7, result);
    }

    @Test
    public void swapWorksCorrectly() {
        int[] array = {49, 12, 22, 65, 94, 7};
        sort.swap(array, 0, 5);
        int[] expectedResult = {7, 12, 22, 65, 94, 49};
        assertTrue(Arrays.equals(expectedResult, array));
    }
    
    @Test
    public void medianIsCalculatedCorrectlyForEvenLengthArray() {
        long[] array = {49, 12, 22, 65, 94, 7}; //sorted: {7, 12, 22, 49, 65, 94}
        long result = sort.median(array);
        assertEquals(35, result);
    }
    
    @Test
    public void medianIsCalculatedCorrectlyForOddLengthArray() {
        long[] array = {12, 22, 65, 94, 7}; //sorted: {7, 12, 22, 65, 94}
        long result = sort.median(array);
        assertEquals(22, result);
    }
}
