package moritz.prog1.exercises.set12;
// Aufgabe 1 Antwort:
// Java kann langsamer sein, wenn man Matrizen ungeschickt als verschachtelte Arrays speichert.
// Das liegt aber nicht an Java selbst, sondern an der Umsetzung.
// Mit einem flachen Array auch für rechenintensive Aufgaben gut geeignet.

public class VectorMathTest {

    public static void main(String[] args) {
        int rows = 1000;
        int cols = 2;

        System.out.println("Zeitmessung Matrix × Vektor:");

        // DefaultMatrix + DefaultVector
        VectorMathFactory.useEfficientMatrix = false;
        VectorMathFactory.useOptimized2D = false;

        Matrix m1 = VectorMathFactory.createMatrix(rows, cols);
        Vector v1 = VectorMathFactory.createVector(cols);

        initMatrixAndVector(m1, v1);
        measureTime("DefaultMatrix + DefaultVector", m1, v1);

        // DefaultMatrix + Vector2
        VectorMathFactory.useOptimized2D = true;

        Vector v2 = VectorMathFactory.createVector(cols);
        initVector(v2);
        measureTime("DefaultMatrix + Vector2", m1, v2);

        // EfficientMatrix + DefaultVector
        VectorMathFactory.useEfficientMatrix = true;
        VectorMathFactory.useOptimized2D = false;

        Matrix m2 = VectorMathFactory.createMatrix(rows, cols);
        Vector v3 = VectorMathFactory.createVector(cols);

        initMatrixAndVector(m2, v3);
        measureTime("EfficientMatrix + DefaultVector", m2, v3);

        // EfficientMatrix + Vector2
        VectorMathFactory.useOptimized2D = true;

        Vector v4 = VectorMathFactory.createVector(cols);
        initVector(v4);
        measureTime("EfficientMatrix + Vector2", m2, v4);
    }

    private static void initMatrixAndVector(Matrix m, Vector v) {
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                m.set(i, j, 1.0);
            }
        }
        initVector(v);
    }

    private static void initVector(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, 1.0);
        }
    }

    private static void measureTime(String name, Matrix m, Vector v) {
        long start = System.nanoTime();
        Vector result = m.mult(v);
        long end = System.nanoTime();

        System.out.printf("%s: %.2f ms%n", name, (end - start) / 1_000_000.0);
    }
}
