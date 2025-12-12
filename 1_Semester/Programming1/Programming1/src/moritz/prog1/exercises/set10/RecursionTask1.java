package moritz.prog1.exercises.set10;

public class RecursionTask1 {
    static void main() {
        System.out.println(fakulty(3));
        System.out.println(gcd(8,4));
    }

    public static int gcd(int x, int y) {
        if (y == 0) {       // trivialer Fall
            return x;
        }
        return gcd(y, x % y);  // nichttrivialer Fall
    }

    public static int fakulty(int number){
        if(number==0){
            return 1;
        }

        return number * fakulty(number-1);
    }
}
