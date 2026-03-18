package ms.prog2.exercises.set02.sequences;

public class ZapMultiples extends Filter{
    private final int base;

    public ZapMultiples(Sequence source, int base) {
        this.base = base;
        super(source);
    }

    @Override
    protected boolean testPassCondition(int element) {
        return element % base != 0; // nur Zahlen, die kein Vielfaches sind
    }
}
