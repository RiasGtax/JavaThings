import impl.TempUtilsImpl;
import models.TempData;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        // Declarar datos
        TempData[] data = {
                new TempData("Madrid", 300, 40),
                new TempData("Madrid", 310, 20),
                new TempData("Madrid", 320, 30)
        };

        TempUtilsImpl.maxTemperatures(310, 330, data);
        System.out.println("------------------------------");

        // Mas datos
        data = new TempData[]{
                new TempData("Madrid", 310, 20),
                new TempData("Malaga", 330, 35),
                new TempData("Madrid", 320, 30)
        };

        TempUtilsImpl.maxTemperatures(310, 330, data);
        System.out.println("------------------------------");

        // Ahora con regiones
        HashMap<String, String> region = new HashMap<String, String>() {{
            put("Mostoles", "Madrid");
            put("Getafe", "Madrid");
            put("Leganes", "Madrid");
            put("Malaga", "Andalucia");
        }};

        // Y mas datos
        data = new TempData[]{
                new TempData("Mostoles", 300, 40),
                new TempData("Malaga", 330, 35),
                new TempData("Leganes", 310, 20),
                new TempData("Getafe", 320, 30)
        };

        TempUtilsImpl.maxTemperaturesInRegion(310, 330, "Madrid", data, region);
        System.out.println("------------------------------");
    }
}
