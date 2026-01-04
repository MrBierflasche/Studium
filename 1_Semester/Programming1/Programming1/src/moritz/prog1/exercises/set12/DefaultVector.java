package moritz.prog1.exercises.set12;


public class DefaultVector implements Vector
{
    private double[] data;

    protected DefaultVector(int size) {
        data = new double[size];
    }

    protected DefaultVector(double... values) {
        data = values.clone();
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public double get(int index) {
        return data[index];
    }

    @Override
    public void set(int index, double value) {
        data[index] = value;
    }

    @Override
    public void setAll(double... values) {
        data = values.clone();
    }

    @Override
    public Vector mult(double factor) {
        DefaultVector result = new DefaultVector(size());
        for (int i = 0; i < size(); i++) {
            result.set(i, get(i) * factor);
        }
        return result;
    }

    @Override
    public Vector plus(Vector vec) {
        if (size() != vec.size()) {
            System.err.println("Fehler: Vektoren haben unterschiedliche Größe");
            return null;
        }

        DefaultVector result = new DefaultVector(size());
        for (int i = 0; i < size(); i++) {
            result.set(i, get(i) + vec.get(i));
        }
        return result;
    }

    @Override
    public Vector minus(Vector vec) {
        if (size() != vec.size()) {
            System.err.println("Fehler: Vektoren haben unterschiedliche Größe");
            return null;
        }

        DefaultVector result = new DefaultVector(size());
        for (int i = 0; i < size(); i++) {
            result.set(i, get(i) - vec.get(i));
        }
        return result;
    }

    @Override
    public double vlength() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += get(i) * get(i);
        }
        return Math.sqrt(sum);
    }
}
