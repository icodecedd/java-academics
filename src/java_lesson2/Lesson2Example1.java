package java_lesson2;

import java.io.*;
import java.util.*;

public class Lesson2Example1 {
	
	// input values in an array. get the sum and sort them in ascending order
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int[] numbers = new int[5];
		int sum = 0;
		
		
		for(int i = 0; i<5; i++) {	
			System.out.print("input numbers " + (i+1) + ": ");
			numbers[i] = Integer.parseInt(br.readLine());
		}
		System.out.print("Contents of array: \n");
		for(int i=0; i<5; i++) {	
			System.out.print(numbers[i] + "\t");
			sum+=numbers[i];
		}
		
		System.out.println("\nsum = " + sum);
		
		Arrays.sort(numbers); // method to sort array in ascending order
		
		System.out.print("Contents of array in Ascending Order: \n");
		for(int i=0; i<5; i++) {	System.out.print(numbers[i] + "\t");
			sum+=numbers[i];
		}	
			
	}
}

