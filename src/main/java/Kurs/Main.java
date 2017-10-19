package Kurs;

import Kurs.Classes.Driver;
import Kurs.Methods.DriverMethods;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<Driver> drivers = new ArrayList<Driver>();
        drivers.add(new Driver(0, "Driver1 name", 10, D, new HashMap<Integer, String>()));
        drivers.add(new Driver(1, "Driver2 name", 5, BCD, new HashMap<Integer, String>()));
        drivers.add(new Driver(2, "Driver3 name", 1, CD, new HashMap<Integer, String>()));
        for (Driver driver : drivers) {
            System.out.println(driver.getDriverId() + " " + driver.getDriverName() + " " + driver.getExperiense() + " " + driver.getDriverClass() + " " + driver.getDriverViolations().entrySet());
        }*/
        DriverMethods driverMethods = new DriverMethods();
        ArrayList<Driver> drivers = driverMethods.generateDriversPark(25);
        for (Driver driver : drivers) {
            System.out.println(driver.getDriverId() + " " + driver.getDriverName() + " " + driver.getDriverSurname());
        }
        //System.out.println(driverMethods.generateDriverName() + " " + driverMethods.generateDriverSurname());
    }
}
