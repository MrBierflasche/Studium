package blatt02;

public class Aufg2_1_Endrekursion {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("factorial(%2d) iterativ: %10d, rekursiv: %10d%n", i, factorialIter(i), factorialRec(i));
		}
	}
	
	public static int factorialIter(int n) {
		int res = 1;
		while (n > 1) {
			res = res * n;
			n--;
		}
		return res;
	}
	
	public static int factorialRec(int n) {
		//TODO
		//TODO
		//TODO
		throw new RuntimeException("Not yet implemented");
	}

}
