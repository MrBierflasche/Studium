package oobasics;

public class RectangleTest {

    public static void main() {
        Rectangle r1 = new Rectangle(0,0,10,10);
        Rectangle r2 = new Rectangle(1,1,10,10);
        Rectangle r3 = new Rectangle(5,5,1,1);
        Rectangle r4 = new Rectangle(7,-3,5,3);

        System.out.println(r1.isDisjoint(r2));
        System.out.println(r1.isDisjoint(r3));
        System.out.println(r1.isDisjoint(r4));


    }
}
