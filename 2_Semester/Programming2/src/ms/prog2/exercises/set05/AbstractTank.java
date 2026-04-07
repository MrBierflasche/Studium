package ms.prog2.exercises.set05;

import java.util.Collections;
import java.util.Iterator;

public abstract class AbstractTank implements Tank {

    @Override
    public Iterator<Tank> iterator() {
        // iterator wird nur bei zusammengesetztem Tank benötigt
        return Collections.emptyIterator();
    }

    @Override
    public abstract Tank clone();
}
