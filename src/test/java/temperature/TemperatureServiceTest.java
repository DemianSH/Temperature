package temperature;

import org.junit.Before;
import org.junit.Test;
import search.BinarySearch;
import sort.QuickSort;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemperatureServiceTest {

    private TemperatureService service;
    private double[] unsortedArrayTest;
    private double[] emptyArrayTest;
    private double[] unavailableRangeArrayTest;

    @Before
    public void setup() {
        service = new TemperatureServiceImpl(new QuickSort(), new BinarySearch());
        unsortedArrayTest = new double[]{-3.5, 3.5, 4, 6.5, -7.2, -6.2, -12, -10, -9.6};
        emptyArrayTest = new double[]{};
        unavailableRangeArrayTest = new double[]{-3.5, 3.5, 4, 6.5, -7.2, -6.2, -12, -10, -9.6, 10000.0};
    }

    @Test
    public void unavailableRangeTest() {
        Map<String,Double> result = service.findCloserToZero(unavailableRangeArrayTest);

        assertTrue(result.containsKey("ERROR"));
        assertEquals(0, result.get("ERROR").compareTo(new Double(0.00)));
    }

    @Test
    public void emptyArray() {
        Map<String,Double> result = service.findCloserToZero(emptyArrayTest);

        assertTrue(result.containsKey("ERROR"));
        assertEquals(0, result.get("ERROR").compareTo(new Double(0.00)));
    }

    @Test
    public void closestToZeroTest() {
        Map<String, Double> result = service.findCloserToZero(unsortedArrayTest);

        assertTrue(result.containsKey("RESULT"));
        assertEquals(0, result.get("RESULT").compareTo(new Double(3.5)));
    }
}
