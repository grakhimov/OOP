package Kurs;

import Kurs.Classes.Bus;
import Kurs.Methods.BusMethods;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*DriverMethods driverMethods = new DriverMethods();
        ArrayList<Driver> drivers = driverMethods.generateDriversPark(25);
        for (Driver driver : drivers) {
            System.out.println(driver.getDriverId() + " " + driver.getDriverName() + " " + driver.getDriverSurname() + " " + driver.getExperiense() + " " + driver.getDriverClass());
        }
        RouteMethods routeMethods = new RouteMethods();
        ArrayList<Route> routes = routeMethods.generateRoutes(25);
        for (Route route: routes) {
            System.out.println(route.getId() + " " + route.getStartTime() + " " + route.getEndTime());
        }*/
        BusMethods busMethods = new BusMethods();
        ArrayList<Bus> buses = busMethods.generateBusPark(25);
        for (Bus bus: buses) {
            System.out.println(bus.getBusId() + " " + bus.getBusNumber());
        }
        busMethods.addBusVoilations(buses, 0, "idiot");
        System.out.println(buses.get(0).getBusId() + buses.get(0).getBusNumber() + buses.get(0).getBusViolations());
    }
}
