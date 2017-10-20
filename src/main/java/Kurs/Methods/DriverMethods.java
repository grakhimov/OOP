package Kurs.Methods;

import Kurs.Classes.Driver;
import Kurs.Constants.DriverClasses;
import Kurs.Constants.DriverNames;
import Kurs.Constants.DriverSurnames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static Kurs.Constants.DriverExperience.MAX_DRIVER_EXPERIENCE;
import static Kurs.Constants.DriverExperience.MIN_DRIVER_EXPERIENCE;

public class DriverMethods {

    public ArrayList<Driver> generateDriversPark(int numberOfDrivers) {
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        for (int i = 0; i < numberOfDrivers; i++) {
            Driver driver = new Driver(i, generateDriverName(), generateDriverSurname(), generateDriverExperience(), generateDriverClass(), new HashMap<Integer, String>());
            drivers.add(driver);
        }
        return drivers;
    }

    private String generateDriverName() {
        int random = new Random().nextInt(DriverNames.values().length);
        return DriverNames.values()[random].name;
    }

    private String generateDriverSurname() {
        int random = new Random().nextInt(DriverSurnames.values().length);
        return DriverSurnames.values()[random].surname;
    }

    private int generateDriverExperience() {
        return new Random().nextInt(MAX_DRIVER_EXPERIENCE.driverExperience - MIN_DRIVER_EXPERIENCE.driverExperience + 1) + MIN_DRIVER_EXPERIENCE.driverExperience;
    }

    private String generateDriverClass() {
        int random = new Random().nextInt(DriverClasses.values().length);
        return DriverClasses.values()[random].toString();
    }
}
