package Kurs;

import Kurs.Classes.Driver;
import Kurs.Methods.DriverMethods;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DriverMethods driverMethods = new DriverMethods();
        ArrayList<Driver> drivers = driverMethods.generateDriversPark(25);
        for (Driver driver : drivers) {
            System.out.println(driver.getDriverId() + " " + driver.getDriverName() + " " + driver.getDriverSurname() + " " + driver.getExperiense() + " " + driver.getDriverClass());
        }
    }
}
