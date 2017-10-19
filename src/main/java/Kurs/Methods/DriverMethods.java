package Kurs.Methods;

import Kurs.Classes.Driver;
import Kurs.Classes.DriverClasses;
import Kurs.Classes.DriverNames;
import Kurs.Classes.DriverSurnames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DriverMethods {
    private int numberOfDrivers;
    private ArrayList<Driver> drivers;

    public ArrayList<Driver> generateDriversPark(int numberOfDrivers) {
        drivers = new ArrayList<Driver>();
        for (int i = 0; i < numberOfDrivers; i++) {
            Driver driver = new Driver(i, generateDriverName(), generateDriverSurname(), 0, DriverClasses.CD, new HashMap<Integer, String>());
            drivers.add(driver);
        }
        return drivers;
    }

    public String generateDriverName() {
        int random = new Random().nextInt(DriverNames.values().length);
        return DriverNames.values()[random].name;
    }

    public String generateDriverSurname() {
        int random = new Random().nextInt(DriverSurnames.values().length);
        return DriverSurnames.values()[random].surname;
    }
}
