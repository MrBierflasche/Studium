import java.util.Arrays;

public class ExerciseSet05 {
    public static void main(String[] args) {
        int selection;
        while (true) {
            System.out.println("1 : Zinsberechnung");
            System.out.println("2 : Durchschnittsberechnung");
            System.out.println("3 : Vektor-Test");
            System.out.println("4 : Maulwurfsimulation");
            System.out.println("0 : Beenden");

            selection = Terminal.readInt("Ihre Wahl");
            switch (selection) {
                case 0:
                    // Programm beenden
                    return;
                case 1:
                    CalculateInterest();
                    break;
                case 2:
                    GetExamResults();
                    break;
                case 3:
                    runVectorTest();
                    break;
                case 4:
                    predictHills();
                    break;
            }
        }
    }

    public static void runVectorTest() {
        // Eingaben
        double[] vector1 = new double[2];
        double[] vector2 = new double[2];
        vector1[0] = Terminal.readDouble("Vektor 1, x");
        vector1[1] = Terminal.readDouble("Vektor 1, y");
        vector2[0] = Terminal.readDouble("Vektor 2, x");
        vector2[1] = Terminal.readDouble("Vektor 2, y");
        double factor = Terminal.readDouble("Faktor");
        int degree = Terminal.readInt("Winkel (in Grad)");

        // Ausgaben
        System.out.println("v1 * fact " + Arrays.toString(mult(vector1, factor)));
        System.out.println("v1 + v2 " + Arrays.toString(plus(vector1, vector2)));
        System.out.println("v1 - v2 " + Arrays.toString(minus(vector1, vector2)));
        System.out.println("vlength(v1) " + vlength(vector1));
        System.out.println("rot(v1, deg) " + Arrays.toString(rotate2d(vector1, degree)));
        System.out.println("next molehill " + Arrays.toString(nextHill(vector2, vector1)));
    }

    public  static void predictHills(){
        double[] previous = {0,0};
        double[] current = {1,0};

        System.out.println("Haufen " + 0 + " : " + current[0] + ", " + current[1]);
        for(int i = 1; i <= 100; i++){
            double[] next = nextHill(current, previous);
            System.out.println("Haufen " + i + " : " + next[0] + ", " + next[1]);

            previous = current;
            current = next;
        }
    }

    public static double[] nextHill(double[] current, double[] previous){
        // Der Richtungsvektor vom da vorherigen zum aktuellen Hügen
        double [] directionVector = minus(current, previous);

        // Richtung um 5 Grad nach links drehen => Bildschirmkoordinatensystem
        double[] rotatedVector = rotate2d(directionVector, 5 );

        // um 1% verringern
        double[] shorterVector = mult(rotatedVector, 0.99);

        // Aktueller Hügel + den gedrehten und verringerten Vektor um den neuen zu erhalten
        return plus(current, shorterVector) ;
    }

    /**
     * Returns the Euclidean norm of the vector
     * <code>vec</code>.
     */
    public static double vlength(double[] vec){
        double result = 0;
        for (double v : vec) {
            result += Math.pow(v, 2);
        }

        result = Math.sqrt(result);
        return result;
    }


    // Bildschirmkoordinatensystem
    /**
     * Rotates the two dimensional vector <code>vec</code> by
     * <code>deg</code> degrees and returns the result.
     */
    public static double[] rotate2d(double vec[], int deg){
        double[] result = new double [2];
        double radians = Math.toRadians(deg);

        result[0] = Math.cos(radians) * vec[0] + Math.sin(radians) * vec[1];
        result[1] = -Math.sin(radians) * vec[0] + Math.cos(radians)* vec[1];

        return  result;
    }


    /**
     * Subtracts <code>vec2</code> from <code>vec1</code> and
     * returns the result. Input vectors are not changed.
     */
    public static double[] minus(double[] vec1, double[] vec2){
        double[] result = new double[vec1.length];
        for(int i = 0; i < vec1.length; i++){
            result[i] = vec1[i] - vec2[i];
        }

        return result;
    }


    /**
     * Adds the vectors <code>vec1</code> and <code>vec2</code>
     * and returns the result. Input vectors are not changed.
     */
    public static double[] plus(double[] vec1, double[] vec2){
        double[] result = new double[vec1.length];
        for(int i = 0; i < vec1.length; i++){
            result[i] = vec1[i] + vec2[i];
        }

        return result;
    }

    /**
     * Multiplies the elements of <code>vec</code> with scalar
     * factor and returns the result. <code>vec</code> is not
     * changed by this operation!
     */
    public static double[] mult(double[] vec, double factor){
        double[] result = new double[vec.length];
        for(int i = 0; i < vec.length; i++){
            result[i] = vec[i] * factor;
        }

        return result;
    }

    public static void GetExamResults(){
        int totalNumbers = Terminal.readInt("Wie viele Zahlen sollen analysiert werden");
        double[] numbers = new double [totalNumbers];

        for (int i = 0; i < totalNumbers; i++) {
            numbers[i] =  Terminal.readDouble("naechste Zahl");
        }

        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        double average = 0;
        String outputNumbers = "OK. Die Zahlen lauten: ";

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }

            average += numbers[i];
            outputNumbers += numbers[i] + " ";
        }

        System.out.println(outputNumbers);
        System.out.println("Min: " + min + " Max: " + max + " Average: " + average / totalNumbers);


    }

    public static void CalculateInterest(){
        double capital = Terminal.readDouble("Geben Sie das Anfangskapital ein [in Euro]");
        double interestRate = Terminal.readDouble("Bitte geben Sie den Zinssatz ein [in %]");
        int years = Terminal.readInt("Geben Sie die Anlagedauer ein [in Jahren]");

        for(int i = 1; i <= years; i++ ){
            capital += capital * interestRate  / 100;
            System.out.println("Kapital nach " + i + " Jahren: " + capital);
        }
    }
}
