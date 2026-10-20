package blatt02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class JuTest2_4_Fragments {
	
	private static final String STR6 = "abcdef";
	private static final String STR10 = "1234567890";
	
	@Test
	void testsplit_1() {
		Set<String> parts1 = Aufg2_3_Fragments.fragments(STR6,1);
		assertEquals(1, parts1.size());
		assertTrue(parts1.contains("abcdef"));
	}
	
	
	@Test
	void testsplit_2() {
		Set<String> parts2 = Aufg2_3_Fragments.fragments(STR6,2);
		assertEquals(5, parts2.size());
		assertTrue(parts2.contains("a|bcdef"));
		assertTrue(parts2.contains("ab|cdef"));
		assertTrue(parts2.contains("abc|def"));
		assertTrue(parts2.contains("abcd|ef"));
		assertTrue(parts2.contains("abcde|f"));
	}
	
	@Test
	void testsplit_3() {
		Set<String> parts3 = Aufg2_3_Fragments.fragments(STR6,3);
		assertEquals(10, parts3.size());
		assertTrue(parts3.contains("a|b|cdef"));
		assertTrue(parts3.contains("a|bc|def"));
		assertTrue(parts3.contains("a|bcd|ef"));
		assertTrue(parts3.contains("a|bcde|f"));
		assertTrue(parts3.contains("ab|c|def"));
		assertTrue(parts3.contains("ab|cd|ef"));
		assertTrue(parts3.contains("ab|cde|f"));
		assertTrue(parts3.contains("abc|d|ef"));
		assertTrue(parts3.contains("abc|de|f"));
		assertTrue(parts3.contains("abcd|e|f"));
	}
	
	@Test
	void testsplit_4() {
		Set<String> parts4 = Aufg2_3_Fragments.fragments(STR6,4);
		assertEquals(10, parts4.size());
		assertTrue(parts4.contains("a|b|c|def"));
		assertTrue(parts4.contains("a|b|cd|ef"));
		assertTrue(parts4.contains("a|b|cde|f"));
		assertTrue(parts4.contains("a|bc|d|ef"));
		assertTrue(parts4.contains("a|bc|de|f"));
		assertTrue(parts4.contains("a|bcd|e|f"));
		assertTrue(parts4.contains("ab|c|d|ef"));
		assertTrue(parts4.contains("ab|c|de|f"));
		assertTrue(parts4.contains("ab|cd|e|f"));
		assertTrue(parts4.contains("abc|d|e|f"));
	}
	
	@Test
	void testsplit_5() {
		Set<String> parts5 = Aufg2_3_Fragments.fragments(STR6,5);
		assertEquals(5, parts5.size());
		assertTrue(parts5.contains("a|b|c|d|ef"));
		assertTrue(parts5.contains("a|b|c|de|f"));
		assertTrue(parts5.contains("a|b|cd|e|f"));
		assertTrue(parts5.contains("a|bc|d|e|f"));
		assertTrue(parts5.contains("ab|c|d|e|f"));
	}
	
	@Test
	void testsplit_6() {
		Set<String> parts6 = Aufg2_3_Fragments.fragments(STR6,6);
		assertEquals(1, parts6.size());
		assertTrue(parts6.contains("a|b|c|d|e|f"));
	}
	
	@Test
	void testsplit_7() {
		Set<String> parts5 = Aufg2_3_Fragments.fragments(STR10,5);
		assertEquals(126, parts5.size());
	}

}
