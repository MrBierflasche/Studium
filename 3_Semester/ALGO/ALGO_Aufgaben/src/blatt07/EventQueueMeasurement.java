package blatt07;

import java.util.Random;

import javax.swing.JOptionPane;

public class EventQueueMeasurement {

	private final static int MIN_N = 10;
	private final static int MAX_N = 100000;

	private final static Random rand = new Random();

	public static void main(String[] args) {
		int maxN = Integer.parseInt(JOptionPane.showInputDialog("Maximum size n = ", MAX_N));

		System.out.println("HeapEventQueue:");
		System.out.printf("| %10s | %14s | %32s | %18s |%n", "n", "n x addEvent", "100 x (addEvent+removeNextEvent)",
				"n x removeNextEvent");
		for (int n = MIN_N; n <= maxN; n *= 10) {
			IEventQueue prioq = new HeapEventQueue(n);
			measurePQRuntime(prioq, n);
		}

		System.out.println();

		System.out.println("SortedEventQueue:");
		System.out.printf("| %10s | %14s | %32s | %18s |%n", "n", "n x addEvent", "100 x (addEvent+removeNextEvent)",
				"n x removeNextEvent");
		for (int n = MIN_N; n <= maxN; n *= 10) {
			IEventQueue prioq = new SortedEventQueue(n);
			measurePQRuntime(prioq, n);
		}

		System.out.println("- done -");
	}

	/**
	 * generates an event with random time
	 */
	private static Event randEntry(int maxValue) {
		int time = rand.nextInt(maxValue);
		return new Event("E_" + time, time);
	}

	/**
	 * Measures runtime of the following scenario:
	 * <ol>
	 * <item>insert n random entries </item> 
	 * <item>100 times insert and extract an entry </item> 
	 * <item >extract all n entries </item>
	 * </ol>
	 */
	private static void measurePQRuntime(IEventQueue prioq, int n) {

		System.out.printf("| %10d |", n);

		// (1) insert n entries
		// at first generate entries
		Event[] entryNew = new Event[n];
		for (int i = 0; i < n; i++) {
			entryNew[i] = randEntry(Integer.MAX_VALUE);
		}

		System.gc();

		// then insert entries (do not measure generation time)
		long s1 = System.nanoTime();
		for (int i = 0; i < n; i++) {

			prioq.addEvent(entryNew[i]);
		}
		long e1 = System.nanoTime();
		System.out.printf("%12.3f ms |", (e1 - s1) / 1e6);

		// (2) 100 times insert an entry and remove an entry
		// generate 100 entries with random priority
		entryNew = new Event[100];
		for (int i = 0; i < entryNew.length; i++) {
			entryNew[i] = randEntry(Integer.MAX_VALUE);
		}

		// repeatedly extract and insert an entry
		long ta = System.nanoTime();
		for (int i = 0; i < entryNew.length; i++) {
			Event next = prioq.removeNextEvent();
			prioq.addEvent(entryNew[i]);
		}
		long tb = System.nanoTime();
		System.out.printf("%30.3f ms |", (tb - ta) / 1e6);

		// (3) remove all n entries from the priority queue
		long s3 = System.nanoTime();
		while (!prioq.isEmpty()) {
			Event next = prioq.removeNextEvent();
		}
		long e3 = System.nanoTime();
		System.out.printf("%17.3f ms |%n", (e3 - s3) / 1e6);

	}
}
