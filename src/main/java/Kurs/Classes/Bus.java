package Kurs.Classes;

import java.util.HashMap;

public class Bus {
    private int busId;
    private String busNumber;
    private HashMap<Integer, String> busViolations;

    public Bus(int busId, String busNumber, HashMap<Integer, String> busViolations) {

        this.busId = busId;
        this.busNumber = busNumber;
        this.busViolations = busViolations;
    }

    public void setBusViolations(HashMap<Integer, String> busViolations) {
        this.busViolations = busViolations;
    }

    public void setBusNumber(String busNumber) {

        this.busNumber = busNumber;
    }

    public int getBusId() {

        return busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public HashMap<Integer, String> getBusViolations() {
        return busViolations;
    }
}
