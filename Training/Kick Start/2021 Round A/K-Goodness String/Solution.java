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
			solution.solve(i, in);
		}
	}

	public void solve(int c, Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int k = in.nextInt();
		String str = in.next();

		int goodness = 0;
		for (int i = 0; i < n/2; i++) {
			if(str.charAt(i) != str.charAt(n-i-1)) {
				goodness++;
			}
		}


		this.print(c, Math.abs(k-goodness));
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}