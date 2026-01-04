package moritz.prog1.exercises.set12;

public class Vector2 implements Vector {
    private double x;
    private double y;

    protected Vector2() {
        this(0, 0);
    }

    protected Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public double get(int index) {
        if (index == 0){
            return x;
        }
        if (index == 1){
            return y;
        }
        System.err.println("Fehler: Vector2 braucht genau 2 Werte");
        return 0;
    }

    @Override
    public void set(int index, double value) {
        if (index == 0) {
            x = value;
        }
        else if (index == 1) {
            y = value;
        }
        else {
            System.err.println("Fehler: Vector2 braucht genau 2 Werte");
        }
    }

    @Override
    public void setAll(double... values) {
        if (values.length != 2) {
            System.err.println("Fehler: Vector2 braucht genau 2 Werte");
            return;
        }
        x = values[0];
        y = values[1];
    }

    @Override
    public Vector mult(double factor) {
        return new Vector2(x * factor, y * factor);
    }

    @Override
    public Vector plus(Vector vec) {
        if (vec.size() != 2) {
            System.err.println("Fehler: Vektoren haben unterschiedliche Größe");
            return null;
        }
        return new Vector2(x + vec.get(0), y + vec.get(1));
    }

    @Override
    public Vector minus(Vector vec) {
        if (vec.size() != 2) {
            System.err.println("Fehler: Vektoren haben unterschiedliche Größe");
            return null;
        }
        return new Vector2(x - vec.get(0), y - vec.get(1));
    }

    @Override
    public double vlength() {
        return Math.sqrt(x * x + y * y);
    }
}
