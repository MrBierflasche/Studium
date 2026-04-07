package ms.prog2.exercises.set05;

public class SphericalTank extends AbstractTank {
    private final double radius;

    @Override
    public String toString() {
        return "SphericalTank{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public Tank clone() {
        return new SphericalTank(radius);
    }

    public SphericalTank(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurface() {
        return 4 * Math.PI * radius * radius;
    }
}
