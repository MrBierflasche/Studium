public class Training25VPrinter {
    private static void printV(int size) {
        int row = 0;
        String leadingBlanks = "";
        while (row < size) {
            System.out.print( leadingBlanks + "x");
            row = row + 1;
            leadingBlanks = leadingBlanks + " ";
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printV(3);
    }
}
