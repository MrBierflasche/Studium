package moritz.prog1.exercises.set08;

public class LeastSquaresEstimatorTest {
    static void main() {
        Point[] sales = {
                new Point(1, 15),
                new Point(2, 37),
                new Point(3, 52),
                new Point(4, 59),
                new Point(5, 83),
                new Point(6, 92)
        };

        // Regression erstellen
        LeastSquaresEstimator estimator = new LeastSquaresEstimator(sales);

        // Ausgabe der gegebenen Verkaufszahlen
        for (int i = 0; i < sales.length; i++) {
            System.out.println("Verkaeufe in Monat " + (i + 1) + ": " + (int)sales[i].getY());
        }

        // Prognose für Monate 7-12
        for (int month = 7; month <= 12; month++) {
            double predicted = estimator.predictY(month);
            System.out.println("Geschaetzte Verkaeufe in Monat " + month + ": " + Math.round(predicted));
        }

//        Point p1 = new Point(1, 1);
//        Point p2 = new Point(2, 2);

//        LeastSquaresEstimator estimator = new LeastSquaresEstimator(p1, p2);
//
//        System.out.println("Steigung m: " + estimator.getM()); // erwartet: 1
//        System.out.println("Achsenabschnitt b: " + estimator.getB()); // erwartet: 0
//        System.out.println("Vorhersage y für x=3: " + estimator.predictY(3)); // erwartet: 3
    }
}
