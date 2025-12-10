package oobasics.tohgame;

public class Rod {
    private final RodID name;
    private Disk[] disks;
    private int size;

    public Rod(RodID name, int capacity) {
        this.name = name;
        this.disks = new Disk[capacity];
    }

    public void push(Disk disk) {
        if (size > 0 && disk.getRadius() > this.disks[size -1].getRadius()) {
            System.out.println("Error: Wrong disk size!");
            return;
        }

        this.disks[this.size] = disk;
        this.size++;
    }

    public Disk pop() {
        return this.disks[--this.size];
    }

    public int getSize() {
        return this.size;
    }

    public RodID getName() {
        return this.name;
    }

    public String toString() {
        return this.getName() + " (" + this.getSize() + ")";
    }
}
