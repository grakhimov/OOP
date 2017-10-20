package Kurs.Methods;

import Kurs.Classes.Route;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.lang.Math.random;

public class RouteMethods {
    DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    private String generateStartTime() {
        return simpleDateFormat.format((long) (random() * 3600000L + 7200000L));
    }

    private String generateEndTime() {
        return simpleDateFormat.format((long) (random() * 3600000L + 72000000L));
    }

    public ArrayList<Route> generateRoutes(int numberOfRoutes) {
        ArrayList<Route> routes = new ArrayList<Route>();
        for (int i = 0; i < numberOfRoutes; i++) {
            routes.add(new Route(i, generateStartTime(), generateEndTime()));
        }
        return routes;
    }
}
