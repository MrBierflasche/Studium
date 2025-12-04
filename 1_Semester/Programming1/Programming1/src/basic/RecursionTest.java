package basic;

public class RecursionTest {

    static void main() {
        System.out.println(isPalindromeRecursive("ABCBA"));
    }

    public static int max(int [] arr, int pos){
        if (pos == arr.length){
            return Integer.MIN_VALUE;
        }
        int maxRest = max(arr, pos + 1);

        return (arr[pos] > maxRest) ? arr[pos] : maxRest;
    }

    // Schreiben Sie einen Palindorm-Test?
    // Beispiel: isPalindrome("ABBA") == true

    public static boolean isPalindrome(String eingabe){
        eingabe = eingabe.toLowerCase().replaceAll(" ", "");
        for (int i = eingabe.length() -1 , j = 0; i >= 0; i--,  j++) {
            if (eingabe.charAt(i) != eingabe.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String eingabe){
        if (eingabe.length() <= 1){
            return true;
        }

        eingabe = eingabe.toLowerCase().replaceAll(" ", "");
        if (eingabe.charAt(0) != eingabe.charAt(eingabe.length() -1)){
            return false;
        }

        return isPalindromeRecursive(eingabe.substring(1, eingabe.length() - 1));
    }
}
