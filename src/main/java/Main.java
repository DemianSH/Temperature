import temperature.TemperatureService;
import temperature.TemperatureServiceFactory;

import static search.KindOfSearch.BINARY_SEARCH;
import static sort.KindOfSort.QUICK_SORT;

public class Main {

    public static void main(String[] args) {
        double[] array = {7, -10, 13, 8, 4, -7.2, -12, -3.7, 3.5, -9.6, 6.5, -1.7, -6.2, 7, 1.7};
        System.out.print("The input data of array temperature : {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("}");

        TemperatureServiceFactory factory = new TemperatureServiceFactory();
        TemperatureService service = factory.getService(QUICK_SORT, BINARY_SEARCH);
        double closestElement = service.findCloserToZero(array);
        System.out.println(closestElement);
    }
}
