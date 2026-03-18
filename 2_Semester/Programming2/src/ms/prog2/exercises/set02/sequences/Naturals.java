package ms.prog2.exercises.set02.sequences;

public class Naturals implements Sequence {

    private int currentNatural;

    public Naturals() {
        currentNatural = 1; // Zahlenfolge beginnt bei 1
    }
    @Override
    public boolean hasNext() {
        return true; // Unendliche Folge
    }

    @Override
    public int nextElement() {
        return currentNatural++;
    }
}
