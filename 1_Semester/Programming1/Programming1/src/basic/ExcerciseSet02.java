package basic;

public class ExcerciseSet02 {
    public static int computeSum(int number) {
        int result = 0; int i = 1;
        while (i <= number) {
            result = result + i; i = i + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int num = Terminal.readInt("Provide a number");
        //System.out.println(computeSum(num));
        //printSequence1(num);
        //printSequence2(num);
        //printSequence3(num);
        printTriangle(num);
    }

    public static void printTriangle(int countOfElements) {
        System.out.println("Visualizes the 12-th triangular number:");
        for (int i = 0; i < countOfElements; i++) {
            String row = "";
            // Leerzeichen pro Reihe hinzufügen
            for (int j = countOfElements - i; j > 1; j--) {
                row += " ";
            }
            // Punkte pro Reihe hinzufügen
            for (int j = 0; j <= i; j++) {
                row += ".";
            }

            System.out.println(row);
        }
    }

     public static void printSequence1(int countOfElements){
        String sequence = "Sequence 1:";
        for(int i = 0; i < countOfElements; i++){
            sequence += " " + i * i;
        }
        System.out.println(sequence);
     }

    public static void printSequence2(int countOfElements){
        String sequence = "Sequence 2:";
        for(int i = 1; i <= countOfElements; i++){
            if(i % 2 == 0){
                sequence += " " + i * - 1;
            }
            else {
                sequence += " " + i;
            }

        }
        System.out.println(sequence);
    }

    public static void printSequence3(int countOfElements){
        String sequence = "Sequence 3:";
        for(int i = 1; i <= countOfElements; i++){
            sequence += " " + ( i * (i + 1)) / 2;
        }
        System.out.println(sequence);
    }

}
