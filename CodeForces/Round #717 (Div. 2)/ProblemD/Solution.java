import java.util.*;
import java.io.*;

/**
 * @author Daniel Melero
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		Solution solution = new Solution();
		for (int i = 1; i <= cases; ++i) {
			System.out.print("Case #" + i + ": ");
			solution.solve(in);
		}
	}

	public void solve(Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		
		/**
		 * Solve Problem Here.
		 */

		System.out.println(n);
	}
}