package blatt05;

import java.util.Random;

import javax.swing.JOptionPane;

public class SortMeasurement {

	public interface DoubleArrayConsumer {
		void accept(double[] arr);
	}
	
	public interface DoubleArrayProducer {
		double[] accept(int n);
	}

	public static final int LENGTH_MIN = 10;

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("Maximum length:", 100000);
		int lengthMax = Integer.parseInt(eingabe);

		measureRuntime("Heapsort (random)", Sort::heapsort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Heapsort (sorted)", Sort::heapsort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Heapsort (reverse)", Sort::heapsort, lengthMax, SortMeasurement::generateReverseSortedData);
		
		measureRuntime("Quicksort (random)", Sort::quicksort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Quicksort (sorted)", Sort::quicksort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Quicksort (reverse)", Sort::quicksort, lengthMax, SortMeasurement::generateReverseSortedData);

		measureRuntime("Mergesort (random)", Sort::mergesort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Mergesort (sorted)", Sort::mergesort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Mergesort (reverse)", Sort::mergesort, lengthMax, SortMeasurement::generateReverseSortedData);

		measureRuntime("Insertionsort (random)", Sort::insertionsort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Insertionsort (sorted)", Sort::insertionsort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Insertionsort (reverse)", Sort::insertionsort, lengthMax, SortMeasurement::generateReverseSortedData);

		measureRuntime("Selectionsort (random)", Sort::selectionsort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Selectionsort (sorted)", Sort::selectionsort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Selectionsort (reverse)", Sort::selectionsort, lengthMax, SortMeasurement::generateReverseSortedData);
		
		measureRuntime("Bubblesort (random)", Sort::bubblesort, lengthMax, SortMeasurement::generateRandomData);
		measureRuntime("Bubblesort (sorted)", Sort::bubblesort, lengthMax, SortMeasurement::generateSortedData);
		measureRuntime("Bubblesort (reverse)", Sort::bubblesort, lengthMax, SortMeasurement::generateReverseSortedData);
		
		System.out.println("--- done ---");
	}

	public static final int REPEAT = 3;


	private static void measureRuntime(String name, DoubleArrayConsumer algorithm, int maxLength, DoubleArrayProducer datagen) {
		System.out.println(name + ":");
		for (int len = LENGTH_MIN; len <= maxLength; len = 10 * len) {
			long sumTime = 0; 
			
			// repeat measurement for length len REPEAT times
			for (int v = 1; v <= REPEAT; v++) {
				double[] data = datagen.accept(len);
				
				System.gc();
				long tStart = System.nanoTime();
				algorithm.accept(data);
				long tEnd = System.nanoTime();
				
				sumTime += (tEnd - tStart);
			}
			// computer average runtime in milliseconds
			double timeMs = sumTime / (REPEAT * 1e6);
			System.out.printf("n = %9d %11.3f ms%n", len, timeMs);
		}
		System.out.println();
	}
	
	

	/**
	 * generates an array filled with random values
	 * 
	 * @param length length of the array to be generated and filled
	 * @return array containing random values
	 */
	public static double[] generateRandomData(int length) {
		Random rand = new Random();
		double[] arr = new double[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100 * length);
		}
		return arr;

	}
	
	public static double[] generateSortedData(int length) {
		double[] arr = new double[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	public static double[] generateReverseSortedData(int length) {
		double[] arr = new double[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -i;
		}
		return arr;
	}
	
	
}
