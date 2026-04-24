package ms.prog2.exercises.set07;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeIterator<T> implements Iterator<T> {

    private final MyDeque<T> deque;
    private int cursor;

    public DequeIterator(MyDeque<T> deque) {
        this.deque = deque;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < deque.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T element = deque.get(cursor);
        cursor++;
        return element;
    }
}
