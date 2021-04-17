package unit_one;

import java.util.Arrays;
// import java.util.Date;


/**
 * Array Size 1000:
 * Time to sort first Array using Insertion Sort method: 3 milliseconds
 * Time to sort first Array using Array.sort method: 1 milliseconds
 * 
 * Array Size 10000:
 * Time to sort first Array using Insertion Sort method: 52 milliseconds
 * Time to sort first Array using Array.sort method: 4 milliseconds
 * 
 * Array Size 100000:
 * Time to sort first Array using Insertion Sort method: 4371 milliseconds
 * Time to sort first Array using Array.sort method: 31 milliseconds
 *
 */

public class Main {

	public static void main(String[] args) {
		
		// Array size 1000 - 10000 - 100000
		final int arrLength = 100000;
		
		// Declare Arrays 
		int[] randomArray1 = new int[arrLength];
		int[] randomArray2 = new int[arrLength];
		
		// Fill both Arrays with the same random integers
		for(int i = 0; i < arrLength; i++) {
			int randomNum = (int)(Integer.MAX_VALUE * Math.random());
			randomArray1[i] = randomNum;
			randomArray2[i] = randomNum;
		}
		
		/*
		Date beforeSortFirst = new Date();
		insertionSort(randomArray1);
		Date afterSortFirst = new Date();
	    System.out.println("Time (milliseconds) = " + (afterSortFirst.getTime() - beforeSortFirst.getTime()));

	    Date beforeSortSecond = new Date();
	    Arrays.sort(randomArray2);
	    Date afterSortSecond = new Date();
	    System.out.println("Time (milliseconds) = " + (afterSortSecond.getTime() - beforeSortSecond.getTime()));
	    */
		
		// print out the time for randomArray1 to be sorted using Insertion Sort method
		long startTimeFirst = System.currentTimeMillis();
		insertionSort(randomArray1);
		long runTimeFirst = System.currentTimeMillis() - startTimeFirst;
		System.out.println(runTimeFirst);
		
		// print out the time for randomArray2 to be sorted using Array.sort method
		long startTimeSecond = System.currentTimeMillis();
		Arrays.sort(randomArray2);
		long runTimeSecond = System.currentTimeMillis() - startTimeSecond;
		System.out.println(runTimeSecond);

	}

	
	// Sort Array using Insertion Sort method from textbook Section 7.4
	public static void insertionSort(int[] A) {
		
		int itemsSorted; 
		
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
			int temp = A[itemsSorted]; 
			int loc = itemsSorted - 1; 
			
			while (loc >= 0 && A[loc] > temp) {
				A[loc + 1] = A[loc]; 
				loc = loc - 1;
			}
			A[loc + 1] = temp; 
		}
	}
}

