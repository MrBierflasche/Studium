package ms.prog2.exercises.set02.sequences;

public class Evens extends Filter{
    public Evens(Sequence source) {
        super(source);
    }

    @Override
    protected boolean testPassCondition(int element) {
        return element % 2 == 0; // nur gerade Zahlen
    }
}
