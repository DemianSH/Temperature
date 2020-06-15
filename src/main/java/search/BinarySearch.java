package search;

import java.math.BigDecimal;

public class BinarySearch implements Search {

    public double findCloserToZero(double[] array) {
        double closestTo = 0;
        int indexOfBegin = 0;
        int indexOfEnd = array.length - 1;
        if (comparingDouble(closestTo, array[indexOfBegin]) == 0 || comparingDouble(closestTo, array[indexOfBegin]) == -1)
            return indexOfBegin;
        else if (comparingDouble(closestTo, array[indexOfEnd]) == 0 || comparingDouble(closestTo, array[indexOfEnd]) == 1)
            return indexOfEnd;

        return searchElement(array, closestTo, indexOfBegin, indexOfEnd);
    }

    private double searchElement(double[] array, double key, int begin, int end) {
        int middle = (begin + end) / 2;

        if (comparingDouble(key, array[middle]) == 1) {
            return moveToLeft(array, key, middle, begin);
        } else {
            return moveToRight(array, key, middle, end);
        }
    }

    private double moveToLeft(double[] array, double key, int middle, int begin) {
        if (middle > 0 && comparingDouble(key, array[middle - 1]) == 1) {
            return getClosest(array[middle - 1], array[middle], key);
        } else {
            return searchElement(array, key, begin, middle);
        }
    }

    private double moveToRight(double[] array, double key, int middle, int end) {
        if (middle < end - 1 && comparingDouble(key, array[middle + 1]) == -1) {
            return getClosest(array[middle], array[middle + 1], key);
        } else {
            return searchElement(array, key, middle + 1, end);
        }
    }

    public double getClosest(double val1, double val2, double closestTo) {
        if (closestTo - val1 >= val2 - closestTo)
            return val2;
        else
            return val1;
    }

    private int comparingDouble(double a, double b) {
        BigDecimal convertedA = new BigDecimal(a);
        BigDecimal convertedB = new BigDecimal(b);
        return convertedA.compareTo(convertedB);
    }
}
