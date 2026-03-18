package ms.prog2.exercises.set02.sequences;

import java.io.Serializable;

public abstract class Filter implements Sequence{
    private final Sequence source;
    private int next;
    private boolean hasNext;

    public Filter(Sequence source) {
        this.source = source;
        computeNext();
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public int nextElement() {
        int result = next; // aktuelles Element zurückgeben
        computeNext();     // nächstes Element vorberechnen
        return result;
    }

    protected abstract boolean testPassCondition(int element);

    //  Berechnet das nächste Element das die Bedingung erfüllt
    private void computeNext() {
       this.hasNext = false;
        while (this.source.hasNext()) {
            int nextTestCandidate = this.source.nextElement();
            if (testPassCondition(nextTestCandidate)) {
                this.next = nextTestCandidate;
                this.hasNext = true;
                break;
            }
        }
    }
}
