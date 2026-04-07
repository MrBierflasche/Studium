package ms.prog2.exercises.set05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeTank  extends AbstractTank {

    private List<Tank> parts =   new ArrayList<>();
    public CompositeTank() {
    }

    public void add(Tank part) {
        parts.add(part);
    }

    @Override
    public double getVolume() {
        double sum = 0;

        for (Tank part : parts) {
            sum += part.getVolume();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompositeTank:\n");

        for (Tank part : parts) {
            sb.append("  ").append(part.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Tank> iterator() {
        return parts.iterator();
    }

    @Override
    public Tank clone() {
        CompositeTank c = new CompositeTank();

        for (Tank part : parts) {
            c.add(part.clone());
        }
        return c;
    }

    @Override
    public double getSurface() {
        double sum = 0;
        for (Tank part : parts) {
            sum += part.getSurface();
        }
        return sum;
    }

    public void remove(Tank part) {
        parts.remove(part);
    }
}
