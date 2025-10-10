public class ExerciseSet02 {
    public static int computeSum(int number) {
        int result = 0; int i = 1;
        while (i <= number) {
            result = result + i; i = i + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(computeSum(10));
    }
}
