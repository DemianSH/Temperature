package temperature;

import search.KindOfSearch;
import search.Search;
import sort.KindOfSort;
import sort.Sort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TemperatureServiceImpl extends TemperatureServiceFactory {

    private static final double MIN_TEMP = -273;
    private static final double MAX_TEMP = 5526;

    public TemperatureServiceImpl(KindOfSort kindOfSort, KindOfSearch kindOfSearch) {
        super(kindOfSort,kindOfSearch);
    }

    public Map<String, Double> findCloserToZero(double[] array) {
        Map<String, Double> result = new HashMap<>();
        if (isEmpty(array)) {
            System.out.println("The input data array of temperatures is empty!");
            result.put("ERROR", 0.00);
            return result;
        }
        sort.sort(array);
        if (isAllowableRangeOfTemp(array)) {
            System.out.println("Not allowable range of temperature");
            result.put("ERROR", 0.00);
            return result;
        }
        result.put("RESULT", search.findCloserToZero(array));
        return result;
    }

    private boolean isAllowableRangeOfTemp(double[] array) {
        double minTemp = array[0];
        double maxTemp = array[array.length - 1];
        return comparingDouble(MIN_TEMP, minTemp) == 1
                ||
                comparingDouble(MAX_TEMP, maxTemp) == -1;
    }

    private boolean isEmpty(double[] array) {
        return array.length == 0;
    }

    private int comparingDouble(double a, double b) {
        BigDecimal convertedA = new BigDecimal(a);
        BigDecimal convertedB = new BigDecimal(b);
        return convertedA.compareTo(convertedB);
    }
}


