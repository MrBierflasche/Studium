package blatt02;

import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Aufg2_3_Fragments {

	
	public static TreeSet<String> fragments(String str, int n) {
		TreeSet<String> result = new TreeSet<>();

		if (n == 1) {
			result.add(str);
			return result;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			String str1 = str.substring(0, i+1);
			String str2 = str.substring(i+1);
			TreeSet<String> fragments = fragments(str2, n-1);
			for (String frag : fragments) {
				String subResult = str1 + "|" + frag;
				result.add(subResult);
			}
		}

		return result;
	}
	

	public static void main(String[] args) {
		demoSplit_1();
		System.out.println();
		demoSplit_2();
	}


	public static void demoSplit_1() {
		Set<String> partitions = fragments("abcdef", 3);
		int count = 0;
		for (String part : partitions) {
			count++;
			System.out.println(count + ": " + part);
//			System.out.println(part);
		}
	}
	
	public static void demoSplit_2() {
		String inp = JOptionPane.showInputDialog("Enter string and number of parts, separated by comma:");
		String[] parts = inp.split(",");
		String str = parts[0].trim();
		int n = Integer.parseInt(parts[1].trim());
		Set<String> partitions = fragments(str, n);
		int count = 0;
		for (String part : partitions) {
			count++;
			System.out.println(count + ": " + part);
		}
	}



}
