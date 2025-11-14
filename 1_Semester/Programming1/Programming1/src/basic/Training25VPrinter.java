package basic;

public class Training25VPrinter {
    private static void printV(int size) {
        int row = 0;
        String leadingBlanks = "";
        while (row < size) {
            System.out.print( leadingBlanks + "x");
            if (row < size) {
                int i = 0;
                while (i < 2 *  (size - row) -1) {
                    System.out.print( " ");
                    i++;
                }

                System.out.print("x");
            }
            row = row + 1;
            leadingBlanks = leadingBlanks + " ";
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printV(3);
    }
}
