package ms.prog2.exercises.set03;

public class Place {
    private final String name;
    private final double x;
    private final double y;

    public Place(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double distanceTo(Place other) {
        // euklidische Metrik in Ebene
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
