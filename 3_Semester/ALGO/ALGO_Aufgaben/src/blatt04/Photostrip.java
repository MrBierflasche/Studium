package blatt04;

/**
 * Represents a sequence of photos
 *
 */
public class Photostrip {

	/** Stores a sequence of photos */
	private Photo [] strip;

	/** Number of photos in the strip */
	private int count = 0;

	/**
	 * generates a photo strip with the given capacity
	 * 
	 */
	public Photostrip(int capacity) {
		strip = new Photo[capacity];
		count = 0;
	}

	/**
	 * Adds another photo to the end of the strip
	 * 
	 * @param p a photo
	 */
	public void add(Photo p) {
		strip[count] = p;
		count++;
	}

	/** returns the number of photos in the strip */
	public int length() {
		return count;
	}

	/**
	 * Returns the contrast category of the photo at position i in the strip.
	 * Positions start at index 0.
	 * 
	 * @param pos position within the strip
	 * @return contrast category of photo at position pos
	 */
	public Contrast getContrast(int pos) {
		return strip[pos].getContrast();
	}

	/**
	 * Swaps photos at position i and j in the strip 
	 * (where 0 <= i < count and 0 <= j < count)
	 */
	public void swap(int i, int j) {
		if (i < 0 || j < 0  || i >= count || j >= count) {
			throw new IllegalArgumentException("swap " + i + "/" + j);
		}
		Photo tmp = strip[i];
		strip[i] = strip[j];
		strip[j] = tmp;;
	}

	/**
	 * Prints all photos
	 */
	public void print() {
		System.out.println("Strip of " + count + " photos:");
		for (int i = 0; i < count; i++) {
			System.out.println("\t" + strip[i]);
		}
	}

	/**
	 * generates a strip of photos of the given length with randomly chosen contrast categories.
	 */
	public static Photostrip generateRandomStrip(int length) {
		Photostrip m = new Photostrip(length);
		for (int i = 0; i < length; i++) {
			double rnd = Math.random();
			if (rnd < 0.25) {
				m.add(new Photo(Contrast.WEAK, "w" + i));
			} else if (rnd < 0.5) {
				m.add(new Photo(Contrast.MEDIUM, "m" + i));
			} else if (rnd < 0.75) {
				m.add(new Photo(Contrast.STRONG, "s" + i));
			} else {
				m.add(new Photo(Contrast.EXTREME, "e" + i));
			}
		}

		return m;
	}

	/**
	 * Checks whether the photos in the strip are correctly arranged according to contrast in the order
	 * weak - medium - strong.
	 */

	public boolean isOrderedByContrast() {
		for (int i = 1; i < count; i++) {
			Contrast val1 = strip[i-1].getContrast();
			Contrast val2 = strip[i].getContrast();
			if (val1.compareTo(val2) > 0) {
				return false;
			}
		}
		
		return true;
		
	}
}
