package blatt01;


//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class JuTest_Aufg15_Recursion {

		
	@Test
	public void testAllMultipleOf_1() {
		int[] a1 = { 3 };
		assertEquals(true, Aufg15_Recursion.allMultipleOf(a1, 3));
		assertEquals(false, Aufg15_Recursion.allMultipleOf(a1, 4));
	}
	
	@Test
	public void testAllMultipleOf_2() {
		int[] a2 = { 3, 6, 9, 12, 30, 21, 27, 3 };
		assertEquals(true, Aufg15_Recursion.allMultipleOf(a2, 3));
		assertEquals(false, Aufg15_Recursion.allMultipleOf(a2, 2));
	}
	
	public static final int LENGTH = 10000000;
	
	@Test
	public void testAllMultipleOf_3() {
		int[] a3 = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			a3[i] = 4*i;
		}
		
		assertEquals(true, Aufg15_Recursion.allMultipleOf(a3, 4));
		assertEquals(false, Aufg15_Recursion.allMultipleOf(a3, 5));

		a3[LENGTH-1] = 13;
		
		assertEquals(false, Aufg15_Recursion.allMultipleOf(a3, 4));
	}
}
