package ms.prog2.exercises.set04;

public class Car {
    private final int length; // in Metern
    private final int capacity; // Passagierkapazität
    private Car next; // nächster Wagen

    public Car(int length, int capacity) {
        this.length = length;
        this.capacity = capacity;
        this.next = null;
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }
}
