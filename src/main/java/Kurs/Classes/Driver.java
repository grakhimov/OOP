package Kurs.Classes;

import java.util.HashMap;

public class Driver {
    private int driverId;
    private String driverName;
    private String driverSurname;
    private int experience;
    private String driverClass;
    private HashMap<Integer, String> driverViolations;

    public Driver(int driverId, String driverName, String driverSurname, int experience, String driverClass, HashMap<Integer, String> driverViolations) {
        this.driverId = driverId;
        this.driverName = driverName;

        this.driverSurname = driverSurname;
        this.experience = experience;
        this.driverClass = driverClass;
        this.driverViolations = driverViolations;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public int getExperience() {
        return experience;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public HashMap<Integer, String> getDriverViolations() {
        return driverViolations;
    }
}
