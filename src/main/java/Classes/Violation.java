package Classes;

public class Violation {
    private String violatedRouteNumber;
    private String violationDate;
    private String violatedDriver;
    private String violationDescription;

    public Violation(String violatedRouteNumber, String violationDate, String violatedDriver, String violationDescription) {
        this.violatedRouteNumber = violatedRouteNumber;
        this.violationDate = violationDate;
        this.violatedDriver = violatedDriver;
        this.violationDescription = violationDescription;
    }

    public String getViolatedRouteNumber() {
        return violatedRouteNumber;
    }

    public void setViolatedRouteNumber(String violatedRouteNumber) {
        this.violatedRouteNumber = violatedRouteNumber;
    }

    public String getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(String violationDate) {
        this.violationDate = violationDate;
    }

    public String getViolatedDriver() {
        return violatedDriver;
    }

    public void setViolatedDriver(String violatedDriver) {
        this.violatedDriver = violatedDriver;
    }

    public String getViolationDescription() {
        return violationDescription;
    }

    public void setViolationDescription(String violationDescription) {
        this.violationDescription = violationDescription;
    }
}
