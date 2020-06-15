package temperature;

import search.Search;
import sort.Sort;

import java.math.BigDecimal;

public class TemperatureServiceImpl implements TemperatureService {

    private Sort sort;
    private Search search;

    private static final double MIN_TEMP = -273;
    private static final double MAX_TEMP = 5526;

    public TemperatureServiceImpl(Sort sort, Search search) {
        this.sort = sort;
        this.search = search;
    }

    public double findCloserToZero(double[] array) {
        if (isEmpty(array)) {
            System.out.println("The input data array of temperatures is empty!");
            return 0.00;
        }
        sort.sort(array);
        if (isAllowableRangeOfTemp(array)) {
            System.out.println("Not allowable range of temperature");
            return 0.00;
        }
        return search.findCloserToZero(array);
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

