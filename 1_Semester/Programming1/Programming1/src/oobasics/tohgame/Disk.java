package oobasics.tohgame;

public class Disk {
    private final int radius;
     public Disk(int radius) {
         this.radius = radius;
     }

     public int getRadius() {
         return this.radius;
     }

     public String toString() {
         return "D(" + this.radius + ")";
     }
}
