package ms.prog2.exercises.set05;

public class CuboidTank extends AbstractTank {
    private final double length;
    private final double width;
    private final double height;

    public CuboidTank(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "CuboidTank{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public Tank clone() {
        return new CuboidTank(length, width, height);
    }

    @Override
    public double getSurface() {
        return 2 * (length * width + length * height + width * height);
    }
}
