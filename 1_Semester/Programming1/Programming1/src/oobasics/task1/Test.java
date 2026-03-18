package oobasics.task1;

public class Test {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        Rational r3 = new Rational(2, 4);

        System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r3));
        System.out.println(r3.equals(r1));
    }
}
