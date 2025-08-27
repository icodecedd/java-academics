package exercises;

public class Recursion {

	// Use recursion to compute the Fibonacci sequence.
	public static void main(String[] args) {
		int result = fibonacci(10); // Compute the 10th Fibonacci number
		System.out.print("result is " + result);
	}

	/**
	 * Computes the Fibonacci number at the given position using recursion.
	 * 
	 * @param num The position in the Fibonacci sequence (0-based index).
	 * @return The Fibonacci number at the given position.
	 */
	public static int fibonacci(int num) {
		if (num > 1) {
			// Sum of the two preceding numbers in the sequence
			return fibonacci(num - 1) + fibonacci(num - 2);
		} else if (num == 1) {
			// Base case: Fibonacci(1) is 1
			return 1;
		} else {
			// Base case: Fibonacci(0) is 0
			return 0;
		}
	}
}
