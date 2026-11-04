package blatt04;


import java.util.ArrayList;
import java.util.List;

public class PhotostripDemo {

	/**
	 * Reorders all photos in the strip by contrast, swapping photos if necessary. 
	 */
	public static void reorder(Photostrip strip) {
		int weakEnd = 0;
		int mediumEnd = 0;
		int strongEnd = 0; // ist gleichzeitig der Start von Extreme
		int i = 0;

		while (i < strip.length()) {
			switch (strip.getContrast(i)) {
				case EXTREME:
					break;  // ist scho richtig
				case STRONG:
					strip.swap(i, strongEnd); // siehe Comment unten
					strongEnd++;
					break;
				case MEDIUM:
					strip.swap(i, strongEnd); // siehe Comment unten
					strip.swap(strongEnd, mediumEnd);
					strongEnd++;
					mediumEnd++;
					break;
				case WEAK:
					strip.swap(i, strongEnd); // Weak von i über alle Contrast nach weakEnd nach vorne durchreichen
					strip.swap(strongEnd, mediumEnd);
					strip.swap(mediumEnd, weakEnd);
					strongEnd++;
					mediumEnd++;
					weakEnd++;
					break;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		demo01();
		System.out.println();
		
		runtimeMeasurement();
	}
	
	public static void demo01() {
		System.out.println("demo01: ");
		Photostrip m1 = new Photostrip(10);
		m1.add(new Photo(Contrast.STRONG, "Anna"));
		m1.add(new Photo(Contrast.WEAK, "Betty"));
		m1.add(new Photo(Contrast.MEDIUM, "Cindy"));
		m1.add(new Photo(Contrast.STRONG, "Dave"));
		m1.add(new Photo(Contrast.EXTREME, "Emmy"));
		m1.add(new Photo(Contrast.MEDIUM, "Fred"));
		m1.add(new Photo(Contrast.WEAK, "Gwendolin"));
		m1.add(new Photo(Contrast.EXTREME, "Henry"));
		m1.add(new Photo(Contrast.MEDIUM, "Jane"));

		m1.print();
		System.out.println("Correctly ordered?: " + m1.isOrderedByContrast());

		System.out.println();
		System.out.println("--- reordered: ---:");

		reorder(m1);
		m1.print();
		System.out.println("Correctly ordered?: " + m1.isOrderedByContrast());
		System.out.println();
	}

	public final static int MIN_LENGTH = 10;
	public final static int MAX_LENGTH = 10000000;

	public static void runtimeMeasurement() {
		System.out.println("Runtime measurement: ");
		for (int count = MIN_LENGTH; count <= MAX_LENGTH; count *= 10) {
			runtimeMS(count);
			
		}
		System.out.println("- done -");
	}
	
	// repetition of measurement for each length
	public static final int REPEATS = 5;
	
	/** generates a random strip of photos and measures the running time
	 *  required to reorder the row.
	 * @param length	   number of photos in the strip
	 * @return         running time for reordering in milliseconds
	 */
	public static double runtimeMS(int length) {
		System.out.printf("n = %9d %n", length);
		
		double totalMS = 0.0;
		
		for (int i = 1; i <= REPEATS; i++) {
			System.out.printf("measurement %2d ", i);
			
			Photostrip m = Photostrip.generateRandomStrip(length);
			System.out.print("(generated): ");
			
			long start = System.nanoTime();
			reorder(m);
			long end = System.nanoTime();
			
			double timeMS =  (end - start) / 1e6;
			totalMS += timeMS;
			System.out.printf(" %8.3f ms.%n", timeMS);
			
			if (!m.isOrderedByContrast()) {
				System.out.println("### photo strip not ordered correctly! ###");
			}
			
		}
		double averageTimeMS = totalMS / REPEATS;
		System.out.printf("average: %8.3f ms.%n%n", averageTimeMS);
		return averageTimeMS;
	}
	
	
}
