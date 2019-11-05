package impl;

import models.TempData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempUtilsImpl {
    public static Map<String, Integer> maxTemperatures(long startTime, long endTime, TempData[] tempData) throws Exception {
        // Comprobar que la lista no venga vacia, en caso contrario excepcion
        if (tempData.length <= 0) throw new Exception("Lista vacia");

        // Resultado
        Map<String, Integer> result = new HashMap<>();

        // Filtramos por fecha maxima y minima
        for (TempData element : tempData) {
            if (element.getTime() >= startTime && element.getTime() <= endTime) {
                // Comprobar si la ciudad ya existe en el Map y su valor es menor al de element
                if (result.containsKey(element.getLocation()) && result.get(element.getLocation()) < element.getTemperature()) {
                    // Actualizar valor
                    result.put(element.getLocation(), element.getTemperature());
                } else {
                    // En caso de que NO exista esta ciudad, añadirla
                    result.put(element.getLocation(), element.getTemperature());
                }
            }
        }

        // Ver resultado
        System.out.println("result");
        System.out.println(result);
        return result;
    }

    public static Map<String, Integer> maxTemperaturesInRegion(long startTime, long endTime, String region, TempData[] tempData, Map<String, String> ciudadEnRegion) throws Exception {
        // Map regiones filtradas
        List<String> filteredRegion = new ArrayList<>();
        for (Map.Entry<String, String> city : ciudadEnRegion.entrySet()) {
            if (city.getValue().equalsIgnoreCase(region) && !filteredRegion.contains(city.getKey())) {
                filteredRegion.add(city.getKey());
            }
        }

        // Ver regiones filtradas
        System.out.println("filteredRegion");
        System.out.println(filteredRegion);

        // Map con las ciudades filtradas
        ArrayList<TempData> cityMap = new ArrayList<>();

        // Filtrar tempData
        for (TempData data : tempData) {
            if (filteredRegion.contains(data.getLocation())) {
                cityMap.add(data);
            }
        }

        // Ver ciudades filtradas
        System.out.println("cityMap");
        System.out.println(cityMap);

        // Resultado
        String currentCity = "";
        int currentTemp = 0;

        for (TempData city : cityMap) {
            if (city.getTime() >= startTime && city.getTime() <= endTime) {
                if (city.getTemperature() > currentTemp) {
                    // Actualizar ciudad y temperatura maxima
                    currentCity = city.getLocation();
                    currentTemp = city.getTemperature();
                }
            }
        }

        // Resultado
        Map<String, Integer> result = new HashMap<>();
        result.put(currentCity, currentTemp);

        // Ver resultado
        System.out.println("result");
        System.out.println(result);

        return result;
    }
}
