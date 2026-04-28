package ms.prog2.exercises.set08;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<T> implements Iterable<T> {
    private final T[] data;
    private int head;              // Index des ersten Elements
    private int size;              // Anzahl aktuell enthaltener Elemente

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapazität muss > 0 sein.");
        }
        data = (T[]) new Object[capacity];
        head = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public T get(int i) {
        checkIndex(i);
        return data[physicalIndex(i)];
    }

    public void addFirst(T elem) {
        checkNotFull();
        head = (head - 1 + data.length) % data.length;
        data[head] = elem;
        size++;
    }

    public T getFirst() {
        checkNotEmpty();
        return data[head];
    }

    public T removeFirst() {
        checkNotEmpty();
        T elem = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return elem;
    }

    // Berechnet die nächste freie Position nach dem aktuellen Ende und fügt das Element dort ein.
    public void addLast(T elem) {
        checkNotFull();
        int tail = (head + size) % data.length;
        data[tail] = elem;
        size++;
    }

    public T getLast() {
        checkNotEmpty();
        return data[physicalIndex(size - 1)];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[physicalIndex(i)]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        sb.append(" ]");
        return sb.toString();    }

    public T removeLast() {
        checkNotEmpty();
        int tail = physicalIndex(size - 1);
        T elem = data[tail];
        data[tail] = null;
        size--;
        return elem;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " bei size=" + size);
        }
    }

    // Berechnet den physischen Array-Index aus dem logischen Index i (relativ zum head)
    private int physicalIndex(int logicalIndex) {
        return (head + logicalIndex) % data.length;
    }

    private void checkNotFull() {
        if (isFull()) {
            throw new IllegalStateException("Deque ist voll.");
        }
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Deque ist leer.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T element = get(cursor);
            cursor++;
            return element;
        }
    }
}
