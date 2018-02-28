package Kurs.Methods;

import java.util.Random;

public class BusMethods {
    private static final String possibleLetters = "ABCEHKMOPTXY";
    private static final int[] possibleBusNumbers = {1,2,3,5,8,13,21};

    public String [][] generateBusPark(int numberOfBuses) {
        String[][] buses = new String[numberOfBuses][];
        for (int i = 0; i < numberOfBuses; i++) {
            buses[i] = generateBus();
        }
        return buses;
    }

    private String[] generateBus(){
        return new String[]{generateBusGovernmentNumber(), String.valueOf(getRandomBusNumber(possibleBusNumbers))};
    }

    private String generateBusGovernmentNumber() {
        char a = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        int b = new Random().nextInt(10);
        int c = new Random().nextInt(10);
        int d = new Random().nextInt(10);
        char e = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        char f = possibleLetters.charAt(new Random().nextInt(possibleLetters.length()));
        return String.valueOf(a).concat(String.valueOf(b)).concat(String.valueOf(c)).concat(String.valueOf(d)).concat(String.valueOf(e)).concat(String.valueOf(f));
    }

    private int getRandomBusNumber(int[] array) {
        return array[new Random().nextInt(array.length)];
    }
}
