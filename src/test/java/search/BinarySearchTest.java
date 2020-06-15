package search;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    private Search search;
    private double[] testSortedArray;
    private BigDecimal expected;

    @Before
    public void setup() {
        search = new BinarySearch();
        testSortedArray = new double[]{-12, -10, -9.6, -7.2, -6.2, -3.5, 3.5, 4, 6.5};
        expected = new BigDecimal(3.5);
    }

    @Test
    public void findCloserToZeroTest() {
        double result = search.findCloserToZero(testSortedArray);
        BigDecimal actual = new BigDecimal(result);
        assertTrue(actual.compareTo(expected) == 0);
    }
}
