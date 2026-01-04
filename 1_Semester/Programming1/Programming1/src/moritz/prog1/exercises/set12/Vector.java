package moritz.prog1.exercises.set12;

public interface Vector {

    int size();

    double get(int index);

    void set(int index, double value);

    void setAll(double... values);

    Vector mult(double factor);

    Vector plus(Vector vec);

    Vector minus(Vector vec);

    double vlength();
}
