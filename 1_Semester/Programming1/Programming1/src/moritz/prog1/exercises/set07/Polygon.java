package moritz.prog1.exercises.set07;

public class Polygon {
    private Point[] points;

    public Polygon(double... coordinates) {
        points = new Point[coordinates.length / 2];

        for (int i = 0; i < coordinates.length / 2; i++) {
            points[i] = new Point(coordinates[2 * i], coordinates[2 * i + 1]);
        }
    }

    public Polygon(Point... points) {
        this.points = points;
    }

    public void smooth() {
        Point[] newPoints = new Point[points.length * 2];
        int length = points.length;

        for (int i = 0; i < points.length; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[(i + 1) % length];

            // Abstand in diesem Beispiel der beiden X - Koordinaten (nextPoint.getX() - currentPoint.getX())
            // Nun möchten wir von dem aktuellen Punkt 1/3 für x1 und 2/3 für x2 addieren
            // für y das selbe

            double x1  = currentPoint.getX() + (nextPoint.getX() - currentPoint.getX()) / 3.0;
            double y1 = currentPoint.getY() + (nextPoint.getY() - currentPoint.getY()) / 3.0;
            double x2  = currentPoint.getX() + 2* (nextPoint.getX() - currentPoint.getX()) / 3.0 ;
            double y2 = currentPoint.getY() + 2* (nextPoint.getY() - currentPoint.getY()) / 3.0;
            newPoints[2 * i] = new Point(x1, y1);
            newPoints[2 * i + 1] = new Point(x2, y2);

        }
        points = newPoints;
    }

    public double computeArea1(){
     double area = 0.0;

     for (int i = 0; i < points.length; i++) {
         // Exception verhindern z.B. bei i + 1 und beim letzten Punkt muss wieder der erste genommen werden ("Kreis wieder geschlossen") => Pn+1 = P1
         int j = (i + 1) % points.length;

         area += (points[i].getY() + points[j].getY()) * (points[i].getX() - points[j].getX());
     }


     return Math.abs(area) / 2;
    }

    public double computeArea2(){
        double area = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            // Beim ersten Element muss das letzte verwendet werden => P1 = Pn+1
            int k = (i - 1 + n) % n;

            area += points[i].getX() * ( points[j].getY() - points[k].getY());
        }


        return Math.abs(area) / 2;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (Point point : points) {
            result += "(" + point.getX() + ", ";
            result += point.getY() + ") ";
        }

        return result + "}";
    }
}
