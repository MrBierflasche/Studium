package ms.prog2.exercises.set04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListBenchmark {

    static final int N = 50000;

    static void main(String[] args) {
        System.out.println("N = " + N);
        System.out.println("Operation | ArrayList (ns) | LinkedList (ns)");
        System.out.println("-".repeat(45));

        bench("Anfügen am Ende",       false, false, false);
        bench("Einschieben am Anfang", true,  false, false);
        bench("Index-Zugriff",         false, true,  false);
        bench("Iterator-Zugriff",      false, false,  true);
    }

    static void bench(String label, boolean front, boolean read, boolean iter) {
        List<Integer> al = new ArrayList<>();
        List<Integer> ll = new LinkedList<>();

        // bei Lesezugriffen müssen die Listen zuerst mit N Elementen befüllt werden
        if ( read || iter) {
            for (int i = 0; i < N; i++)
            {
                al.add(i); ll.add(i);
            }
        }
        long t1 = measure(al, front, read, iter);
        long t2 = measure(ll, front, read, iter);
        System.out.println(label + " | " + t1 + " | " + t2);
    }

    static long measure(List<Integer> list, boolean front, boolean read, boolean iter) {
        long start = System.nanoTime();
        int sum = 0;

        // Zugriff über Iterator
        if (iter) {
            for (int x : list) {
                sum += x;
            }
            // Zugriff über Index
        } else if (read) {
            for (int i = 0; i < N; i++) {
                sum += list.get(i);
            }
            //  Einfügen, entweder am Anfang oder am Ende
        } else {
            for (int i = 0; i < N; i++) {
                if (front) {
                    list.add(0, i);
                } else {
                    list.add(list.size(), i);
                }
            }
        }
        return System.nanoTime() - start;
    }
}
