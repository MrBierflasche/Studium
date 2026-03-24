package ms.prog2.exercises.set03;

import java.util.Scanner;

public class TSPTest {

    private TSP createFirstTSP() {
        Tour tour = new Tour(
                new Place("A", 1, 2),
                new Place("B", 1, 1),
                new Place("C", 2, 2),
                new Place("D", 2, 1),
                new Place("E", 3, 2),
                new Place("F", 3, 1)
        );
        return new TSP(tour, "Leiterplattenbohrproblem 1");
    }

    private TSP createSecondTSP() {
        Tour tour = new Tour(
                new Place("A", 1, 7),
                new Place("B", 1, 6),
                new Place("C", 1, 5),
                new Place("D", 1, 4),
                new Place("E", 2, 6),
                new Place("F", 2, 5),
                new Place("G", 4, 7),
                new Place("H", 4, 4),
                new Place("I", 4, 3),
                new Place("J", 4, 2),
                new Place("K", 4, 1)
        );
        return new TSP(tour, "Leiterplattenbohrproblem 2");
    }

    private TSP createThirdTSP() {
        Tour tour = new Tour(
                new Place("A", 1, 7),
                new Place("B", 1, 6),
                new Place("C", 1, 5),
                new Place("D", 1, 4),
                new Place("E", 2, 6),
                new Place("F", 2, 5),
                new Place("G", 4, 7),
                new Place("H", 4, 4),
                new Place("I", 4, 3),
                new Place("J", 4, 2),
                new Place("K", 4, 1),
                new Place("L", 5, 7),
                new Place("M", 5, 4),
                new Place("N", 5, 3),
                new Place("O", 5, 2)
        );
        return new TSP(tour, "Leiterplattenbohrproblem 3");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TSPTest tspTest = new TSPTest();

        System.out.println("Bitte wählen Sie ein TSP-Problem aus:");
        System.out.println("1 - Leiterplattenbohrproblem 1");
        System.out.println("2 - Leiterplattenbohrproblem 2");
        System.out.println("3 - Leiterplattenbohrproblem 3");
        System.out.print("Ihre Wahl: ");

        int choice = scanner.nextInt();
        TSP tsp;

        switch (choice) {
            case 1:
                tsp = tspTest.createFirstTSP();
                break;
            case 2:
                tsp = tspTest.createSecondTSP();
                break;
            case 3:
                tsp = tspTest.createThirdTSP();
                break;
            default:
                System.out.println("Ungültige Eingabe! Programm wird beendet.");
                scanner.close();
                return;
        }

        System.out.println("\nAusgewähltes Problem:");
        System.out.println(tsp);

        System.out.println("\nAlgorithmus wird gestartet...");
        tsp.solve();

        System.out.println("\nErgebnis:");
        System.out.println(tsp);

        scanner.close();
    }
}