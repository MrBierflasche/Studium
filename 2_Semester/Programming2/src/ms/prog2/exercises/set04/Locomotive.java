package ms.prog2.exercises.set04;

public class Locomotive {
    private final int length; // in Metern
    private final int type;
    private Car first; // erster Wagen

    public Locomotive(int length, int type) {
        this.length = length;
        this.type = type;
        this.first = null;
    }

    public int getLength() {
        return length;
    }

    public int getType() {
        return type;
    }

    public Car getFirst() {
        return first;
    }

    public void setFirst(Car first) {
        this.first = first;
    }
}
