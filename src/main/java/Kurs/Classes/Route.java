package Kurs.Classes;

public class Route {
    private int number;
    private String startTime;
    private String endTime;

    public Route(int number, String startTime, String endTime) {

        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumber() {

        return number;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
