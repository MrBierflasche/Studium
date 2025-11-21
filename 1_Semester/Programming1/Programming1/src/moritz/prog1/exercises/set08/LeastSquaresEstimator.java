package moritz.prog1.exercises.set08;

public class LeastSquaresEstimator {
    private final Point[] points;
    private double m;
    private double b;

    public LeastSquaresEstimator(Point... points) {
        this.points = points;
        calculate();
    }

    public double getM() { return m; }
    public double getB() { return b; }

    private void calculate (){
        int n = points.length;
        if (n < 2){
            return;
        }

        //Mittelwerte berechnen
        double meanX = 0;
        double meanY = 0;
        for (Point p : points) {
            meanX += p.getX();
            meanY += p.getY();
        }
        meanX /= n;
        meanY /= n;

        // Zähler und Nenner berechnen
        double numerator = 0;
        double denominator = 0;
        for (Point p : points) {
            numerator += (p.getX() - meanX) * (p.getY() - meanY);
            denominator += Math.pow((p.getX() - meanX ), 2);
        }

        // nicht durch 0 dividieren
        if (denominator == 0){
            return;
        }
        this.m = numerator / denominator;
        this.b = meanY - this.m * meanX;
    }

    public double predictX (double y){
        if (this.m == 0){
            return 0;
        }
        return (y - this.b) / m ;
    }

    public double predictY (double x){
        return this.m * x + this.b;
    }
}
