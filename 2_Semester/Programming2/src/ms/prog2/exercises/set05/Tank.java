package ms.prog2.exercises.set05;

import java.util.Iterator;

public interface Tank  extends Iterable<Tank>{
    double getVolume();
    double getSurface();
    String toString();
    Iterator<Tank> iterator();
    Tank clone();
}
