package blatt02;

import java.util.Set;
import java.util.TreeSet;

public class Aufg2_2_Brackets {

	/** generates all correctly nested sequences of round brackets
	 *  that can be build from n pairs of brackets.*/
	public static Set<String> nestedBrackets(int n) {
		//TODO
		//TODO
		//TODO
		throw new RuntimeException("Not yet implemented");
	}
	
	
	public static void main(String[] args) {
		Set<String> res = nestedBrackets(4);
		int count = 0;
		for (String s : res) {
			count++;
			System.out.println(count + ": " + s);
		}

	}
}
