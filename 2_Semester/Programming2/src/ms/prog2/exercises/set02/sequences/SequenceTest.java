package ms.prog2.exercises.set02.sequences;

public class SequenceTest {
    public static void println(Sequence seq) {
        int count = 0;
        String result = "";

        while (seq.hasNext() && count < 10) {
            if (count > 0) {
                result += ", ";
            }
            result += seq.nextElement();
            count++;
        }

        // Falls mehr als 10 vorhanden dann '...' ausgeben
        if (seq.hasNext()) {
            result += ", ...";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        println(new Naturals());
        println(new Evens(new Range(7, 14)));
        println(new ZapMultiples(new Range(7, 14), 3));
    }
}
