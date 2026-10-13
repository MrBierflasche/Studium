package blatt01;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JuTest_Aufg13_Dominates2 {

	@Test
	public void testDominatesTrue() {
		assertTrue(Aufg13_Dominates.dominates_v2("abbac", "bcab"));
		assertTrue(Aufg13_Dominates.dominates_v2("ccbbaa", "aabbcc"));
		assertTrue(Aufg13_Dominates.dominates_v2("abcdefg", "abcdeg"));
		assertTrue(Aufg13_Dominates.dominates_v2("", ""));
		assertTrue(Aufg13_Dominates.dominates_v2("xyz", ""));
		assertTrue(Aufg13_Dominates.dominates_v2("ababecg", "bcba"));
	}

	@Test
	public void testDominatesFalse() {
		assertFalse(Aufg13_Dominates.dominates_v2("abcd", "baxc"));
		assertFalse(Aufg13_Dominates.dominates_v2("abbde", "abdde"));
		assertFalse(Aufg13_Dominates.dominates_v2("aa", "ba"));
		assertFalse(Aufg13_Dominates.dominates_v2("", "b"));
	}
	
	@Test
	public void testDominatesRandomTrue() {
		for (int i = 0; i < 100; i++) {
			String[] strPair = Aufg13_Dominates.generateDomStrings(100);
			String str1 = strPair[0];
			String str2 = strPair[1];
			assertTrue(Aufg13_Dominates.dominates_v2(str1, str2));
		}
	}

	@Test
	public void testDominatesRandomFalse() {
		for (int i = 0; i < 100; i++) {
			String[] strPair = Aufg13_Dominates.generateNonDomString(100);
			String str1 = strPair[0];
			String str2 = strPair[1];
			assertFalse(Aufg13_Dominates.dominates_v2(str1, str2));
		}
	}

	private static final int MAX_LENGTH = 10000000;

	@Test
	public void testDominatesLongTrue() {
		for (int length = 1000; length <= MAX_LENGTH; length *= 10) {
			String[] strPair = Aufg13_Dominates.generateDomStrings(length);
			String str1 = strPair[0];
			String str2 = strPair[1];
			assertTrue(Aufg13_Dominates.dominates_v2(str1, str2));
		}
	}

	@Test
	public void testDominatesLongFalse() {
		for (int length = 1000; length <= MAX_LENGTH; length *= 10) {
			String[] strPair = Aufg13_Dominates.generateNonDomString(length);
			String str1 = strPair[0];
			String str2 = strPair[1];
			assertFalse(Aufg13_Dominates.dominates_v2(str1, str2));
		}
	}
}
