package Kurs.Methods;

import Kurs.Constants.DriverClasses;
import Kurs.Constants.DriverNames;
import Kurs.Constants.DriverSurnames;

import java.util.Random;

import static Kurs.Constants.DriverExperience.MAX_DRIVER_EXPERIENCE;
import static Kurs.Constants.DriverExperience.MIN_DRIVER_EXPERIENCE;

public class DriverMethods {

    public String[] generateDriver(){
        return new String[]{generateDriverName(), generateDriverSurname(), generateDriverClass(), String.valueOf(generateDriverExperience())};
    }
    public String [][] generateDriversPark(int numberOfDrivers){
        String[][] drivers = new String[numberOfDrivers][];
        for (int i = 0; i < numberOfDrivers; i++) {
            drivers[i] = generateDriver();
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
