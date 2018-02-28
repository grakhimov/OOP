package Kurs.Methods;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import static java.lang.Math.random;

public class RouteMethods {
    DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
    private static final int[] possibleBusNumbers = {1,2,3,5,8,13,21};

    private String generateStartTime() {
        return simpleDateFormat.format((long) (random() * 3600000L + 7200000L));
    }

    private String generateEndTime() {
        return simpleDateFormat.format((long) (random() * 3600000L + 72000000L));
    }

    public String[][] generateRoutes(int numberOfRoutes){
        String[][] routes = new String[numberOfRoutes][];
        for (int i = 0; i < numberOfRoutes; i++) {
            routes[i] = generateRoute();
        }
        return routes;
    }
    private String[] generateRoute(){
        return new String[]{String.valueOf(getRandomBusNumber(possibleBusNumbers)), generateStartTime(), generateEndTime()};
    }
    private int getRandomBusNumber(int[] array) {
        return array[new Random().nextInt(array.length)];
    }
}
