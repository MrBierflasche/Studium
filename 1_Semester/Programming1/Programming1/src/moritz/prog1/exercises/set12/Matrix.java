package moritz.prog1.exercises.set12;

public interface Matrix {
    int rows();

    int cols();

    double get(int row, int col);

    void set(int row, int col, double value);

    void setAll(double[][] values);

    Vector mult(Vector vec);
}
