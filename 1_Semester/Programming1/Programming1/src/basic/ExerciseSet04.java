package basic;

import java.util.ArrayList;
import java.util.List;

public class ExerciseSet04 {
    public static void main(String[] args) {
        //startByteOverflowDemo();
        //demonstrateArithmeticOperations();
        // Java verwendet bei Modulo "symmetrische"
        //convertToBinary();
        convertHexToDec0();
        //convertToNumber('F');
    }
    public static void startByteOverflowDemo() {
        byte num = 0;
        int i = 0;
        while (i < 10) {
            System.out.print(num + " ");
            num+=30;
            i++;
        }
        System.out.println(0);
    }

    public static void demonstrateArithmeticOperations(){
        int firstOperand  = Terminal.readInt("Please provide a number for the first operand");
        int secondOperand = Terminal.readInt("Please provide a number for the second operand");

        System.out.println(firstOperand + " + " + secondOperand +  " = " + (firstOperand + secondOperand));
        System.out.println(firstOperand + " - " + secondOperand +  " = " + (firstOperand - secondOperand));
        System.out.println(firstOperand + " * " + secondOperand +  " = " + (firstOperand * secondOperand));
        System.out.println(firstOperand + " / " + secondOperand +  " = " + (firstOperand / secondOperand));
        System.out.println(firstOperand + " % " + secondOperand +  " = " + (firstOperand % secondOperand));
    }

    /*bitnumber 6 = 0110 ; 1 = 0001

    i= 1 : 010
    Lösung beim &: 010, daher wird eine 1 ausgegeben

     i= 3: 1000
    Lösung beim & = 0000, daher wird eine 0 ausgegeben*/

    public static void convertToBinary(){
        int bitNumber  = Terminal.readInt("Please provide a number");
        System.out.println("Binary representation (horizontal!)");
        for(int i = 31; i >= 0; i--){
            if ((bitNumber & 1 << i) != 0)
            {
                System.out.print(1);
                continue;
            }
            System.out.print(0);
        }
        System.out.println();
    }

    /**
     * Template which reads a line of symbols and prints each symbol together
     * with its code number. It can be used as starting point for the
     * implementation of a hex-to-dec converter.
     */
    public static void convertHexToDec0() {

        System.out.print("Please provide a hexadecimal number (e.g. 1f): ");
        int result = 0;
        List<Integer> values = new ArrayList<>();

        char ch = Terminal.readChar();

        while (ch != '\n') {
            int returnValue = convertToNumber(ch);
            if (returnValue == -1){
                System.out.print("Invalid Character");
                return;
            }

            // Alle konvertierte Werte einer Liste hinzufügen
            values.add(returnValue);

            ch = Terminal.readChar();
        }


        // Alle Werte entsprechend potenzieren
        for(int  i = 0; i < values.size(); i++){
            result += (int) (values.get(i) * Math.pow(16, values.size() - i -1));
        }
        System.out.println("Corresponding decimal number: " + result);
    }

    /**
     * Converts a hexadecimal digit into the corresponding
     * number.
     * @return value 0-16 or -1 for wrong digits.
     **/
    public static int convertToNumber(char ch) {
        int asciiPos = ch - '0';

        // Wenn Ergebnis 0-9 direkt zurückgeben
        if (asciiPos >= 0 && asciiPos <= 9){
            return asciiPos;
        }

        // Wenn 17 (A) bis 22(F), dann zahl -7 und zurückgeben
        if (asciiPos >= 49 && asciiPos <= 54){
            return asciiPos  -39 ;
        }

        // Bei falschen Zeichen
        return -1;
    }
}
