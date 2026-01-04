package moritz.prog1.exercises.set12;

public class DefaultMatrix implements Matrix {
    private double[][] data;

    protected DefaultMatrix(int rows, int cols) {
        data = new double[rows][cols];
    }

    // Standard: 1x1 Matrix mit 0
    protected DefaultMatrix() {
        data = new double[1][1];
    }

    @Override
    public int rows() {
        return data.length;
    }

    @Override
    public int cols() {
        return data[0].length;
    }

    @Override
    public double get(int row, int col) {
        return data[row][col];
    }

    @Override
    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    @Override
    public void setAll(double[][] values) {
        if (values.length != rows() || values[0].length != cols()) {
            System.err.println("Fehler: Falsche Matrixgröße");
            return;
        }
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                data[i][j] = values[i][j];
            }
        }
    }

    @Override
    public Vector mult(Vector vec) {
        if (vec.size() != cols()) {
            System.err.println("Fehler: Vektor hat falsche Größe für Multiplikation");
            return null;
        }

        Vector result = VectorMathFactory.createVector(rows());
        for (int i = 0; i < rows(); i++) {
            double sum = 0;
            for (int j = 0; j < cols(); j++) {
                sum += data[i][j] * vec.get(j);
            }
            result.set(i, sum);
        }
        return result;
    }
}
