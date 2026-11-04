package blatt04;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class JuTestReorder {
	
	private static Photostrip longStrip;
	
	@BeforeAll
	public static void initLong() {
		longStrip = Photostrip.generateRandomStrip(10000000);
	}

	@Test
	public void test1() {
		Photostrip row1 = new Photostrip(10);
		row1.add(new Photo(Contrast.STRONG, "Anny"));
		row1.add(new Photo(Contrast.EXTREME, "Betty"));
		row1.add(new Photo(Contrast.MEDIUM, "Caesar"));
		row1.add(new Photo(Contrast.STRONG, "Dave"));
		row1.add(new Photo(Contrast.WEAK, "Emmy"));
		row1.add(new Photo(Contrast.EXTREME, "Fred"));
		row1.add(new Photo(Contrast.MEDIUM, "Henry"));

		PhotostripDemo.reorder(row1);

		assertTrue(row1.isOrderedByContrast());
	}

	/** test 100 times reordering of a random row of 50 photos */
	@Test
	public void test2() {
		for (int i = 0; i <= 100; i++) {
			Photostrip row2 = Photostrip.generateRandomStrip(50);
			PhotostripDemo.reorder(row2);
			assertTrue(row2.isOrderedByContrast());
		}
	}

	/** test reordering of a long random photo strip */
	@Test
	public void test3() {
		Photostrip row3 = Photostrip.generateRandomStrip(1000000);
		PhotostripDemo.reorder(row3);
		assertTrue(row3.isOrderedByContrast());
	}

	/** check that reordering keeps the number of weak contrast, medium contrast and strong contrast photos */
	@Test
	public void test4() {
		Photostrip row4 = Photostrip.generateRandomStrip(10000);
		int countWeak = 0;
		int countMedium = 0;
		int countStrong = 0;
		int countExtreme = 0;
		
		for (int pos = 0; pos < row4.length(); pos++) {
			if (row4.getContrast(pos) == Contrast.WEAK)
				countWeak++;
			else if (row4.getContrast(pos) == Contrast.MEDIUM)
				countMedium++;
			else if (row4.getContrast(pos) == Contrast.STRONG)
				countStrong++;
			else if (row4.getContrast(pos) == Contrast.EXTREME)
				countExtreme++;
		}
		System.out.println("# weak:   " + countWeak);
		System.out.println("# medium: " + countMedium);
		System.out.println("# strong: " + countStrong);

		PhotostripDemo.reorder(row4);
		assertTrue(row4.isOrderedByContrast());

		for (int pos = 0; pos < row4.length(); pos++) {
			if (row4.getContrast(pos) == Contrast.WEAK)
				countWeak--;
			else if (row4.getContrast(pos) == Contrast.MEDIUM)
				countMedium--;
			else if (row4.getContrast(pos) == Contrast.STRONG)
				countStrong--;
			else if (row4.getContrast(pos) == Contrast.EXTREME)
				countExtreme--;
		}
		assertEquals(0, countWeak);
		assertEquals(0, countMedium);
		assertEquals(0, countStrong);
		assertEquals(0, countExtreme);
	}


	@Test
	@Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
	public void testRuntime2() {
		PhotostripDemo.reorder(longStrip);
	}

}
