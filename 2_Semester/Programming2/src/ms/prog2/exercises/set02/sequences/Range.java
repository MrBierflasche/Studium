package ms.prog2.exercises.set02.sequences;

import java.io.Serializable;

public class Range implements Sequence {
    private int currentElement;
    private final int end;

    public Range(int start, int end) {
        this.currentElement = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return currentElement <= end;
    }

    @Override
    public int nextElement() {
        return currentElement++;
    }
}
