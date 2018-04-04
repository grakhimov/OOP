package Kurs.Classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Route {
    public static final String[] possibleBusNumbers = {"1", "2", "3", "5", "8", "13", "21"};
    DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
    private String routeNumber;
    private String routeStartTime;
    private String routeEndTime;

    public Route(String routeNumber, String routeStartTime, String routeEndTime) {
        this.routeNumber = routeNumber;
        this.routeStartTime = routeStartTime;
        this.routeEndTime = routeEndTime;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteStartTime() {
        return routeStartTime;
    }

    public void setRouteStartTime(String routeStartTime) {
        this.routeStartTime = routeStartTime;
    }

    public String getRouteEndTime() {
        return routeEndTime;
    }

    public void setRouteEndTime(String routeEndTime) {
        this.routeEndTime = routeEndTime;
    }
}
