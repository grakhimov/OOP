package Kurs.Classes;

public enum DriverSurnames {
    SMIRNOV("Smirnov"),
    IVANOV("Ivanov"),
    KUZNETSOV("Kuznetsov"),
    POPOV("Popov"),
    SOKOLOV("Sokolov"),
    LEBEDEV("Lebedev"),
    KOZLOV("Kozlov"),
    NOVIKOV("Novikov"),
    MOROZOV("Morozov"),
    PETROV("Petrov");

    public String surname;

    DriverSurnames(String surname) {
        this.surname = surname;
    }
}
