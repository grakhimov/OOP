package Kurs.Methods;

import Kurs.Classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class CurrentDayMethods {
    public boolean busIsBroken() {
        return Math.random() >= 0.95;
    }

    public boolean driverIsIll() {
        return Math.random() >= 0.9;
    }

    public CurrentDay generateDay(ArrayList<Bus> buses, ArrayList<Driver> drivers, ArrayList<Route> routes, Date date) {
        ArrayList<Bus> availableBuses = new ArrayList<Bus>();
        ArrayList<Driver> availableDrivers = new ArrayList<Driver>();
        for (Bus bus : buses) {
            if (!busIsBroken()) {
                availableBuses.add(bus);
            }
        }
        for (Driver driver : drivers) {
            if (!driverIsIll()) {
                availableDrivers.add(driver);
            }
        }

        return new CurrentDay(date, availableDrivers, routes, availableBuses);
    }

    /*public ArrayList<BusWithDriverOnRoute> busWithDriverOnRoute(CurrentDay currentDay) {
        for (int i = 0; i < currentDay.getTodayDrivers().size(); i++) {
            for (int j = 0; j < currentDay.getTodayBuses().size(); j++) {
                for (int k = 0; k < currentDay.getTodayRoutes().size(); k++) {

                }
            }
        }
        Driver driver = currentDay.getTodayDrivers().get(new Random().nextInt(currentDay.getTodayDrivers().size()));
        Bus bus = currentDay.getTodayBuses().get(new Random().nextInt(currentDay.getTodayBuses().size()));
        Route route = currentDay.getTodayRoutes().get(new Random().nextInt(currentDay.getTodayRoutes().size()));
        return new ArrayList<BusWithDriverOnRoute>(driver, bus, route);
    }*/
}
