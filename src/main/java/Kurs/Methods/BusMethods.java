package Kurs.Methods;

import Kurs.Classes.Bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BusMethods {
    private static final String possibleLetters = "ABCEHKMOPTXY";

    public ArrayList<Bus> generateBusPark(int numberOfBuses) {
        ArrayList<Bus> busPark = new ArrayList<Bus>();
        for (int i = 0; i < numberOfBuses; i++) {
            busPark.add(new Bus(i, generateBusNumber(), new HashMap<Integer, String>()));
        }
        return busPark;
    }

    public String generateBusNumber() {
        char a = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        int b = new Random().nextInt(10);
        int c = new Random().nextInt(10);
        int d = new Random().nextInt(10);
        char e = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        char f = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        return String.valueOf(a).concat(String.valueOf(b)).concat(String.valueOf(c)).concat(String.valueOf(d)).concat(String.valueOf(e)).concat(String.valueOf(f));
    }
}
