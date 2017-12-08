package Kurs.Classes;

public class BusWithDriverOnRoute {
    private Driver driver;
    private Bus bus;
    private Route route;

    public BusWithDriverOnRoute(Driver driver, Bus bus, Route route) {

        this.driver = driver;
        this.bus = bus;
        this.route = route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
