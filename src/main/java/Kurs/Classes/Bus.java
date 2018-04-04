package Kurs.Classes;

public class Bus {
    private String governmentNumber;
    public static final String possibleLettersAndDigits = "ABCEHKMOPTXY0123456789";
    private static final int[] possibleBusNumbers = {1, 2, 3, 5, 8, 13, 21};
    private String busRouteNumber;

    public Bus(String governmentNumber, String busRouteNumber) {
        this.governmentNumber = governmentNumber;
        this.busRouteNumber = busRouteNumber;
    }

    public void setGovernmentNumber(String governmentNumber) {
        this.governmentNumber = governmentNumber;
    }

    public String getBusRouteNumber() {
        return busRouteNumber;
    }

    public String getGovernmentNumber() {

        return governmentNumber;
    }

    public void setBusRouteNumber(String busRouteNumber) {

        this.busRouteNumber = busRouteNumber;
    }

}
