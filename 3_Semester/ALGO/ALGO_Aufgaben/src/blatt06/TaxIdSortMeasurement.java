package blatt06;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class TaxIdSortMeasurement {

	public static final int MIN_N = 10;
	public static final int MAX_N = 1000000;
	
	/** Measure runtime of sorting lists of persons using radixsort and standard Java sort. */
	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("Maximum length:", MAX_N);
		int lengthMax = Integer.parseInt(eingabe);
		for (int n = MIN_N; n <= lengthMax ; n *= 10) {
			measureSort(n);
		}
		
		System.out.println("--- done ---");

	}
	
	public static void measureSort(int n) {
		System.out.printf("n = %10d persons: ", n);
		Person[] alist1 = Person.generatePersonList(n);
		Person[] alist2 = alist1.clone();

		System.out.print("taxIdSort() ");
		long start1 = System.nanoTime();
		Person.taxIdSort(alist1);
		long end1 = System.nanoTime();
		double time1ms = (end1 - start1)/10e6;
		System.out.printf("%8.2f ms ", time1ms);
		
		
		System.out.print("| Arrays.sort() ");
		long start2 = System.nanoTime();
		Arrays.sort(alist2);
		long end2 = System.nanoTime();
		double time2ms = (end2 - start2)/10e6;
		System.out.printf("%8.2f ms %n", time2ms);
		
	}


}
