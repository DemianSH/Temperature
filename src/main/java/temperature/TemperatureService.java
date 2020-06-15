package temperature;

import java.util.Map;

public interface TemperatureService {

    Map<String, Double> findCloserToZero(double[] array);
}
