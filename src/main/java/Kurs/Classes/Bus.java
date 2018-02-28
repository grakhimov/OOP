package Kurs.Classes;

public class Bus {
    private String governmentNumber;
    private int busNumber;

    public Bus(String governmentNumber, int busNumber) {

        this.governmentNumber = governmentNumber;
        this.busNumber = busNumber;
    }

    public void setBusNumber(int busNumber) {

        this.busNumber = busNumber;
    }

    public String getGovernmentNumber() {

        return governmentNumber;
    }

    public int getBusNumber() {
        return busNumber;
    }

}
