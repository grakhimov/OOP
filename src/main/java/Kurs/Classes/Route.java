package Kurs.Classes;

public class Route {
    private int id;
    private String startTime;
    private String endTime;

    public Route(int id, String startTime, String endTime) {

        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {

        return id;
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
