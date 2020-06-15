import temperature.TemperatureService;
import temperature.TemperatureServiceFactory;
import temperature.TemperatureServiceImpl;

import java.util.Map;

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

        TemperatureService service = new TemperatureServiceImpl(QUICK_SORT, BINARY_SEARCH);

        Map<String, Double> result = service.findCloserToZero(array);
        if(result.containsKey("ERROR")) {
            System.out.println("ERROR: Something went wrong, please check input date");
        } else {
            double closestElement = result.get("RESULT");
            System.out.println("The closest temperature to zero is : " + closestElement);
        }
    }
}
