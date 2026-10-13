package blatt01;

import java.util.Arrays;

public class Aufg15_Recursion {
	
	
	public static boolean allMultipleOf(int[] arr, int n) 
	{
		if (arr.length == 1){
			return (arr[0] % n) == 0;
		}

		int mid = arr.length / 2;
		return allMultipleOf( Arrays.copyOfRange(arr, 0, mid), n) && allMultipleOf(Arrays.copyOfRange(arr, mid, arr.length), n) ;
	}
	

	public static void main(String[] args) {
		System.out.println("allMultipleOf:");
		int[] arr1 = { 2, 4, 6, 8 };
		System.out.println("arr1: " + Arrays.toString(arr1));
		System.out.println("n = 1" + ": " + allMultipleOf (arr1, 1));
		System.out.println("n = 2" + ": " + allMultipleOf (arr1, 2));
		System.out.println("n = 3" + ": " + allMultipleOf (arr1, 3));
		System.out.println();
		int[] arr2 = { 0, 3, 6, 9, 15 };
		System.out.println("arr2: " + Arrays.toString(arr2));
		System.out.println("n = 1" + ": " + allMultipleOf (arr2, 1));
		System.out.println("n = 2" + ": " + allMultipleOf (arr2, 2));
		System.out.println("n = 3" + ": " + allMultipleOf (arr2, 3));
	
	}


}
