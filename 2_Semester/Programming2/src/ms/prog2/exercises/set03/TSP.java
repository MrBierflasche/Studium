package ms.prog2.exercises.set03;

public class TSP {
    private Tour tour;
    private final String name;
    public TSP(Tour tour, String name) {
        this.tour = tour;
        this.name = name;
    }

    public double getTotalDistance() {
        double distance = 0.0;
        Place[] places = tour.getPlaces();

        // bis zum vorletzten Punkt
        for (int i = 0; i < places.length - 1; i++) {
            distance += places[i].distanceTo(places[i + 1]);
        }

        // zurück zum Startpunkt
        distance += places[places.length - 1].distanceTo(places[0]);
        return distance;
    }

    // Greedy-Algorithmus
    public void solve() {
        Place[] places = tour.getPlaces();
        int n = places.length;

        // Neue Tour mit berechneter Route
        Place[] solved = new Place[n];
        // Bereits besuchte Orte
        boolean[] visited = new boolean[n];

        // Starte beim ersten Ort
        solved[0] = places[0];
        visited[0] = true;

        for (int i = 1; i < n; i++) {
            // Aktueller Ort ist der zuletzt hinzugefügte
            Place current = solved[i - 1];
            double minDistance = Double.MAX_VALUE;
            int nearestIndex = -1;

            // Finde den nächsten noch nicht besuchten Ort
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    double distance = current.distanceTo(places[j]);
                    // Überprüfen ob dieser Ort näher ist als bisher der kürzeste
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestIndex = j;
                    }
                }
            }

            // Ort zur neuen Route hinzufügen
            solved[i] = places[nearestIndex];
            visited[nearestIndex] = true;
        }

        tour = new Tour(solved);
    }

    @Override
    public String toString() {
        String result = "TSP: " + name + "\nOrte: ";

        Place[] places = tour.getPlaces();

        for (int i = 0; i < places.length; i++) {
            result += places[i].getName() + "(" + places[i].getX() + "," + places[i].getY() + ")";
            if (i < places.length - 1) {
                result += " -> "; // Beim letzten kein Pfeil
            }
        }

        result += " -> " + places[0].getName(); // zurück zum Start
        result += "\nGesamtdistanz: " + getTotalDistance();
        return result;
    }
}
