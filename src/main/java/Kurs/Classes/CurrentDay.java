package Kurs.Classes;

import java.util.ArrayList;
import java.util.Date;

public class CurrentDay {
    private Date day;
    private ArrayList<Driver> todayDrivers;
    private ArrayList<Route> todayRoutes;
    private ArrayList<Bus> todayBuses;

    public CurrentDay(Date day, ArrayList<Driver> todayDrivers, ArrayList<Route> todayRoutes, ArrayList<Bus> todayBuses) {

        this.day = day;
        this.todayDrivers = todayDrivers;
        this.todayRoutes = todayRoutes;
        this.todayBuses = todayBuses;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public ArrayList<Driver> getTodayDrivers() {
        return todayDrivers;
    }

    public void setTodayDrivers(ArrayList<Driver> todayDrivers) {
        this.todayDrivers = todayDrivers;
    }

    public ArrayList<Route> getTodayRoutes() {
        return todayRoutes;
    }

    public void setTodayRoutes(ArrayList<Route> todayRoutes) {
        this.todayRoutes = todayRoutes;
    }

    public ArrayList<Bus> getTodayBuses() {
        return todayBuses;
    }

    public void setTodayBuses(ArrayList<Bus> todayBuses) {
        this.todayBuses = todayBuses;
    }
}
