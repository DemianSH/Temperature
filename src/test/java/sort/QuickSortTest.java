package sort;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class QuickSortTest {

    private Sort sort;
    private double[] testUnsortedArray;
    private BigDecimal expectedMin;
    private BigDecimal expectedMax;

    @Before
    public void setup() {
        sort = new QuickSort();
        testUnsortedArray = new double[]{-3.5, 3.5, 4, 6.5, -7.2, -6.2, -12, -10, -9.6};
        expectedMin = new BigDecimal(-12.0);
        expectedMax = new BigDecimal(6.5);
    }

    @Test
    public void sortTest() {
        sort.sort(testUnsortedArray);
        BigDecimal actualMin = new BigDecimal(testUnsortedArray[0]);
        BigDecimal actualMax = new BigDecimal(testUnsortedArray[testUnsortedArray.length - 1]);
        assertTrue(actualMin.compareTo(expectedMin) == 0);
        assertTrue(actualMax.compareTo(expectedMax) == 0);
    }
}
