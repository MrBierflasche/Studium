package moritz.prog1.exercises.set12;

public class EfficientMatrix implements Matrix{
    private final int rows;
    private final int cols;
    private final double[] data;

    protected EfficientMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows * cols];
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int cols() {
        return cols;
    }

    @Override
    public double get(int row, int col) {
        if (!validIndices(row, col)) {
            System.err.println("Ungültige Indices: row=" + row + ", col=" + col);
            return 0;
        }
        // row * cols -> überspringt alle Elemente vorheriger Zeilen
        // + col -> verschiebt innerhalb der aktuellen Zeile auf die gewünschte Spalte
        return data[row * cols + col];
    }

    @Override
    public void set(int row, int col, double value) {
        if (!validIndices(row, col)) {
            System.err.println("Ungültige Indices: row=" + row + ", col=" + col);
            return;
        }
        data[row * cols + col] = value;
    }

    @Override
    public void setAll(double[][] values) {
        if (values.length != rows || values[0].length != cols) {
            System.err.println("Fehler: Falsche Matrixgröße");
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i * cols + j] = values[i][j];
            }
        }
    }

    @Override
    public Vector mult(Vector vec) {
        if (vec.size() != cols) {
            System.err.println("Fehler: Vektor hat falsche Größe für Multiplikation");
            return null;
        }

        Vector result = VectorMathFactory.createVector(rows);
        for (int i = 0; i < rows; i++) {
            double sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += data[i * cols + j] * vec.get(j);
            }
            result.set(i, sum);
        }
        return result;
    }

    private boolean validIndices(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
