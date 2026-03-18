package ms.prog2.exercises.set02.sequences;

public interface Sequence {

    // liefert die Information, ob es ein weiteres Folgenelement gibt
    boolean hasNext();

    int nextElement(); // liefert das nächste Element (eine ganze Zahl)
}
