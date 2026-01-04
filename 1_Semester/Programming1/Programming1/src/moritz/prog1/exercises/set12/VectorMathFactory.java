package moritz.prog1.exercises.set12;

public class VectorMathFactory {
    public static boolean useOptimized2D = true;
    public static boolean useEfficientMatrix = true;


    public static Vector createVector(int size){
        if (size == 2 && useOptimized2D) {
            return new Vector2(0, 0);
        } else {
            return new DefaultVector(size);
        }
    }

    public static Vector createVector(double... values) {
        if (values.length == 2 && useOptimized2D) {
            return new Vector2(values[0], values[1]);
        } else {
            return new DefaultVector(values);
        }
    }

    public static Matrix createMatrix(int rows, int cols) {
        if (useEfficientMatrix) {
            return new EfficientMatrix(rows, cols);
        } else {
            return new DefaultMatrix(rows, cols);
        }
    }
}
