package Kurs.Constants;

public enum DriverExperience {

    MAX_DRIVER_EXPERIENCE(25),
    MIN_DRIVER_EXPERIENCE(5);

    public int driverExperience;

    DriverExperience(int driverExperience) {
        this.driverExperience = driverExperience;
    }
}
