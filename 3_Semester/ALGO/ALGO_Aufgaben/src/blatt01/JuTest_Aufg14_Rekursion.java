package blatt01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JuTest_Aufg14_Rekursion  {


	@Test
	public void testContains0() {
		double[] a0 = {};
		assertEquals(false, Aufg14_Rekursion.contains(3.0, a0, a0.length-1));
	}
		
	@Test
	public void testContains1() {
		double[] a1 = { 3.0 };

		assertEquals(true,Aufg14_Rekursion.contains(3.0, a1, a1.length-1));
		assertEquals(false,Aufg14_Rekursion.contains(4.0, a1, a1.length-1));
		
	}
		
	@Test
	public void testContains2() {
		
		double[] a2 = { 3.0, 4.0, 8.0 };
		assertEquals(true,Aufg14_Rekursion.contains(3.0, a2, a2.length-1));
		assertEquals(true,Aufg14_Rekursion.contains(4.0, a2, a2.length-1));
		assertEquals(false,Aufg14_Rekursion.contains(5.0, a2, a2.length-1));
		assertEquals(true,Aufg14_Rekursion.contains(8.0, a2, a2.length-1));
	}


	
	@Test
	void testIsPalindrome_True() {

		char[] seq1 = { 'a', 'b', 'b', 'a' };
		assertTrue(Aufg14_Rekursion.isPalindrome(seq1));

		char[] seq2 = { 'a', 'b', 'c', 'b', 'a' };
		assertTrue(Aufg14_Rekursion.isPalindrome(seq2));

		char[] seq3 = { 'a', 'a' };
		assertTrue(Aufg14_Rekursion.isPalindrome(seq3));

		char[] seq4 = { 'a' };
		assertTrue(Aufg14_Rekursion.isPalindrome(seq4));
	}

	@Test
	void testIsPalindrome_False() {
		char[] seq5 = { 'a', 'b', 'a', 'b' };
		assertFalse(Aufg14_Rekursion.isPalindrome(seq5));

		char[] seq6 = { 'a', 'b', 'c', 'd', 'b', 'a' };
		assertFalse(Aufg14_Rekursion.isPalindrome(seq6));
	}
}
