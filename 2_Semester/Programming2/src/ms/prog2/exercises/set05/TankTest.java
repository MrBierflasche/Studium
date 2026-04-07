package ms.prog2.exercises.set05;

import java.util.Iterator;

public class TankTest {
    static void main(String[] args) {

        // Zweiter Test
        CompositeTank original = new CompositeTank();
        Tank t1 = new CuboidTank(2, 3, 4);
        Tank t2 = new CylindricalTank(1, 5);

        original.add(t1);
        original.add(t2);

        CompositeTank copy = (CompositeTank) original.clone();

        // erstes Teil löschen über Iterator
        Iterator<Tank> it = original.iterator();
        if (it.hasNext()) {
            it.next();
            it.remove();
        }

        System.out.println("Original:");
        System.out.println(original);

        System.out.println("Kopie:");
        System.out.println(copy);

        // Erster Test
//        Tank t1 = new CuboidTank(2, 3, 4);
//        Tank t2 = new CylindricalTank(1, 5);
//        Tank t3 = new SphericalTank(2);
//
//        CompositeTank subSystem = new CompositeTank();
//        subSystem.add(t1);
//        subSystem.add(t2);
//
//        CompositeTank system = new CompositeTank();
//        system.add(subSystem);
//        system.add(t3);
//
//        System.out.println(system);
//        System.out.println("Gesamtvolumen: " + system.getVolume());
//        System.out.println("Gesamtoberfläche: " + system.getSurface());
//
//        System.out.println("Iteriere über obere Tanks:");
//        for (Tank t : system) {
//            System.out.println(t);
//        }
    }
}
