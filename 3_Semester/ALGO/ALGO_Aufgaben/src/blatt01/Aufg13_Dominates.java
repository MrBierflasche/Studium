package blatt01;

import java.util.Random;
import javax.swing.JOptionPane;

public class Aufg13_Dominates {

	private static Random rand = new Random();


	public static boolean dominates(String s1, String s2) {
		//return dominates_v1(s1, s2);
		return dominates_v2(s1, s2);
	}
	
	
	public static boolean dominates_v2(String s1, String s2) {
		int[] s1Counter = countChars(s1);
		int[] s2Counter = countChars(s2);

		for (int i = 0; i < 256; i++) {
			if (s1Counter[i] < s2Counter[i]) {
				return false;
			}
		}

		return true;
	}

	public static int[] countChars(String s){
		int[] result = new int[256];
		for(int i = 0; i < s.length(); i++){
			result[s.charAt(i)]++;
		}

		return result;
	}
	
	public static boolean dominates_v1(String s1, String s2) {
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			int count1 = countChar(ch, s1);
			int count2 = countChar(ch, s2);
			if (count1 < count2) {
				return false;
			}
		}
		return true;
	}
	
	private static int countChar(char ch, String str) {
		int count = 0;
		for (char ch2 : str.toCharArray()) {
			if (ch == ch2) {
				count++;
			}
		}
		return count;
	}
	
	

	/**
	 * Perform runtime measurements  
	 * 
	 */
	public static void main(String[] args) {
		dominatesDemo(); // simple examples for dominates()
		
		// measure runtime of dominates() for increasing string lengths
		String input = JOptionPane.showInputDialog("maximum string length n:");
		if (input == null) {
			System.out.println("Cancelled!");
			return;
		}
		int maxLength = Integer.parseInt(input);
	
		System.out.println("dominates: "); 
		for (int len = 100; len <= maxLength; len *= 10) {
			String[] strPair = generateDomStrings(len);
			boolean result = measureRuntimeDominates(strPair[0], strPair[1]);
			if (result == false) {
				throw new RuntimeException("Wrong result!");
			} else {
				System.out.println("O.K.");
			}
		}
		
		
		System.out.println("- done -");
	}

	
	/** Generate random string of given length with charaters between 'A' and 'z'
	 */
	public static String buildRandomString(int length) {
		StringBuilder sb1 = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			char ch = (char) (rand.nextInt('z'-'A') + 'A');
			sb1.append(ch);
		}
		return sb1.toString();
	}
	
	/** generates a pair of strings so that the first one dominates the second one */
	public static String[] generateDomStrings(int length) {
		String s1 = buildRandomString(length);

		//build other string with characters from s1 randomly permuted
		StringBuilder sb2 = new StringBuilder(s1);
		for (int j = 0; j <= length / 4; j++) {
			//change characters at random positions
			int pos1 = rand.nextInt(length);
			int pos2 = rand.nextInt(length);
			char tmp1 = sb2.charAt(pos1);
			char tmp2 = sb2.charAt(pos2);
			sb2.setCharAt(pos1, tmp2);
			sb2.setCharAt(pos2, tmp1);
		}
		String s2 = sb2.toString();
	
		return new String[]{s1,s2};
		
	}
	
	/**  generates a pair of strings so that the first does not dominate the second one */
	public static String[] generateNonDomString(int length) {
		String s1 = buildRandomString(length);
		StringBuilder sb2 = new StringBuilder(s1);
		sb2.reverse();
		int pos = rand.nextInt(sb2.length());
		if (sb2.charAt(pos) == 'x') {
			sb2.setCharAt(pos, 'y');
		} else {
			sb2.setCharAt(pos, 'x');
		}
		String s2 = sb2.toString();

		return new String[]{s1,s2}; 
		
	}
	
	
	/** Measures runtime of method  */
	private static boolean measureRuntimeDominates(String s1, String s2) {
		int length = s1.length();
		long tStart = System.nanoTime();
		boolean res = dominates(s1, s2);
		long tEnd = System.nanoTime();
		
		
		System.out.printf("length n = : %8d, result: %8b, runtime: %10.2f ms%n", length, res, (tEnd - tStart)/1e6);
		return res;
	}
	
	
	/** some simple examples for dominates() */
	private static void dominatesDemo() {
		System.out.println("aabcde/acd (true expected): " + dominates("aabcde", "acd"));
		System.out.println("abcdcba/dcbb (true expected): " + dominates("abcdcba", "dcbb"));
		System.out.println("abcdcba/abbaa (false expected): " + dominates("abbcca", "abbaab"));
		System.out.println("abcdcba/dcxb (false expected): " + dominates("aabbccdd", "abxc"));
		System.out.println();

	}
}
