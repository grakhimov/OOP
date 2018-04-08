package Classes;

public class Driver {
    private String driverName;
    private String driverSurname;
    private String driverExperience;
    private String driverClass;

    public Driver(String driverName, String driverSurname, String driverExperience, String driverClass) {
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.driverExperience = driverExperience;
        this.driverClass = driverClass;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public String getDriverExperience() {
        return driverExperience;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverExperience(String driverExperience) {
        this.driverExperience = driverExperience;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

}
