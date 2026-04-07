package ms.prog2.exercises.set05;

public class CylindricalTank extends AbstractTank{
    private final double radius;
    private final double height;

    @Override
    public String toString() {
        return "CylindricalTank{" +
                "radius=" + radius +
                ", height=" + height +
                '}';
    }

    @Override
    public Tank clone() {
        return new CylindricalTank(radius, height);
    }

    public CylindricalTank(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getSurface() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
