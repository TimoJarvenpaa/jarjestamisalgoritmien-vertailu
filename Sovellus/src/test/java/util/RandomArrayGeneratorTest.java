package util;

import static org.junit.Assert.assertTrue;

import domain.Sort;
import org.junit.Before;
import org.junit.Test;

public class RandomArrayGeneratorTest {
    
    Sort sort;
    RandomArrayGenerator rand;
    int[] array;
    
    @Before
    public void setUp() {
        rand = new RandomArrayGenerator(100);
        array = rand.getRandomArray(10);
        sort = new Sort(array, 1);
    }
    
    @Test
    public void arrayValuesAreLessThanUpperBound() {
        int max = sort.maxValue(array);
        assertTrue(max <= 10);
    }
    
    @Test
    public void arrayValuesAreGreaterThanZero() {
        int min = sort.minValue(array);
        assertTrue(min > 0);
    }
    
}
