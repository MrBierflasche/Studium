package basic;

import java.util.*;

public class ExerciseSet06 {
    // Bergaufgabe static Arrays
    static String[] placeNames = {"Angeregg", "Hanslettalm", "Wiedersberger_Horn", "Hanslettalm", "Angeregg"};
    static int[] placesHeight = {950, 1616, 2127, 1616, 950 }; // in Meter
    static  double[]  placesDist = {0.0, 3.5, 5.0, 7.5, 10.0  };
    static int upwardSpeed = 300; // m/h
    static int downwardSpeed = 500; // m/h
    static int horizontalSpeed = 4; // km/h


    static Scanner sc = new Scanner(System.in);
    static void main() {
        int selection;
        while (true) {
            System.out.println("1 : Array aufsteigend sortieren");
            System.out.println("2 : Zufallszahl erraten");
            System.out.println("3 : Vorgegebenes Muster in einem Text suchen");
            System.out.println("4 : Tourenplanung");
            System.out.println("0 : Beenden");

            System.out.println("Ihre Wahl ");
            selection = sc.nextInt();
            switch (selection) {
                case 0:
                    // Programm beenden
                    return;
                case 1:
                    System.out.println(Arrays.toString(sort(generateArray(10, 0, 20))));
                    break;
                case 2:
                    guessRandomNumber();
                    break;
                case 3:
                    System.out.println(find("abcdcd", "cd"));
                    break;
                case 4:
                    readTourInfos();
                    createTimePlan();
                    break;
            }
        }
    }

    public static void readTourInfos(){
        System.out.print("Number of places (-1 for default route): ");
        int routeLength = sc.nextInt();

        // Standard Werte aus den Static Arrays verwenden
        if (routeLength == -1){
            return;
        }

        placeNames = new String[routeLength];
        placesHeight = new int[routeLength];
        placesDist = new double[routeLength];

        for (int i=0; i<routeLength; i++){
            System.out.println( i + 1 + ". Place");

            System.out.println("Name: ");
            placeNames[i] = sc.next();

            System.out.println("Height [m] :");
            placesHeight[i] = sc.nextInt();

            System.out.println("Dist. from start [km] ");
            sc.useLocale(Locale.US);  // Punkt als Dezimaltrennzeichen
            placesDist[i] = sc.nextDouble();
        }

        System.out.print("Upward speed [m/h]: ");
        upwardSpeed = sc.nextInt();

        System.out.print("Downward speed [m/h]: ");
        downwardSpeed = sc.nextInt();

        System.out.print("Horizontal speed [km/h]: ");
        horizontalSpeed = sc.nextInt();

    }

    public static void createTimePlan() {

        double time = 0.0;
        System.out.println(placeNames[0] + " 0:00");

        for (int i = 0; i < placeNames.length - 1; i++) {

            double distanz = placesDist[i + 1] - placesDist[i];
            int heightDiff = placesHeight[i + 1] - placesHeight[i];

            double horizontalTime = distanz / horizontalSpeed;

            double verticalTime;
            if (heightDiff >= 0) {
                verticalTime = heightDiff / (double) upwardSpeed;
            } else {
                verticalTime = Math.abs(heightDiff) / (double) downwardSpeed;
            }

            double resultTime = Math.max(horizontalTime, verticalTime) + Math.min(horizontalTime, verticalTime) / 2.0;

            time += resultTime;

            int hours = (int) time;
            int minutes = (int) ((time - hours) * 60);

            System.out.println(placeNames[i + 1] + " " + hours + ":" + String.format("%02d", minutes));
        }
    }

    public static int find(String text, String pattern){
        // letzter möglicher Startindex, sonst geht es länger als der text => text.length() - pattern.length()
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            while (j < pattern.length() &&
                    text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            // Wenn alle Zeichen des Patterns überprüft wurde dann return
            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void guessRandomNumber(){
        System.out.println("I found a number between 1 and 20. Guess its value ...");
        Random rand = new Random();
        int randomNumber = rand.nextInt(1, 21);
        int userNumber;

        do {
            userNumber = sc.nextInt();
            System.out.println("Your number:  " + userNumber);
            if(userNumber > randomNumber){
                System.out.println("My number is smaller!");
                continue;
            }

            if(userNumber < randomNumber){
                System.out.println("My number is larger!");
            }
        }while(randomNumber != userNumber);

        System.out.println("You got it!");

    }

    public static  int[] sort (int [] arr){
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            int pos = i;

            while (pos > 0 && temp < arr[pos - 1]){
              arr[pos] = arr[pos - 1];
              pos--;
            }

            arr[pos] = temp;
        }

        return arr;
    }

    public static int[] generateArray(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(min, max +1) ;
        }

        return arr;
    }


}
