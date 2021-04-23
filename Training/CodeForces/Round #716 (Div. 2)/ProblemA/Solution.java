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
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		String res = "NO";
		for (int i = 0; i < n; i++) {
			if (!isPerfectSquare(in.nextInt())) {
				res = "YES";
			}
		}

		System.out.println(res);
	}

	private boolean isPerfectSquare(int value) {
		double sqrt = Math.sqrt((double)value);
		return sqrt == Math.round(sqrt);
	}
}