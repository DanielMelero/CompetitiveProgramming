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
			solution.solve(in);
		}
	}

	public void solve(Scanner in) {
		long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
		long div = Long.parseLong("2050000000000000000");
		int count = -1;
		while (div >= 2050) {
			if (n-div >= 0) {
				n -= div;
				if (count == -1) count = 1;
				else count++;
			} else {
				div /= 10;
			}
		}
		if (n > 0) count = -1;

		System.out.println(count);
	}
}