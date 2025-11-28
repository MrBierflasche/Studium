package basic;

public class RecursionTest {

    static void main() {
        int [] arr = {5, 2, 36, 1};
        System.out.println(max(arr, 0));
    }

    public static int max(int [] arr, int pos){
        if (pos == arr.length){
            return Integer.MIN_VALUE;
        }
        int maxRest = max(arr, pos + 1);

        return (arr[pos] > maxRest) ? arr[pos] : maxRest;
    }
}
