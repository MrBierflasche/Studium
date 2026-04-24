package ms.prog2.exercises.set07;

public class MyDequeUtil {
    public static <T> MyDeque<T> merge(MyDeque<? extends T> d1, MyDeque<? extends T> d2) {
        MyDeque<T> result = new MyDeque<>(d1.capacity() + d2.capacity());

        // Elemente der ersten Deque hinzufügen
        for (int i = 0; i < d1.size(); i++) {
            result.addLast(d1.get(i));
        }

        // Elemente der zweiten Deque hinzufügen
        for (int i = 0; i < d2.size(); i++) {
            result.addLast(d2.get(i));
        }

        return result;
    }

    public static <T extends Comparable<? super T>> MyDeque<T> selectLess(MyDeque<T> deq, T limit) {
        MyDeque<T> result = new MyDeque<>(deq.capacity());

        for (int i = 0; i < deq.size(); i++) {
            T current = deq.get(i);
            // Wenn current < limit, ist das Ergebnis von compareTo negativ
            if (current.compareTo(limit) < 0) {
                result.addLast(current);
            }
        }

        return result;
    }
}
