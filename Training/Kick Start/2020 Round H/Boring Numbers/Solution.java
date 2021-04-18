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
		int l = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int r = in.nextInt();
		int count=0;
		for (int i = l; i <= r; i++) {
			if (isBoring(i)) count++;
		}

		this.print(c, count);
	}

	private boolean isBoring(int n) {
		String s = "" + n;
		for (int i = 0; i < s.length(); i++){
			if (Integer.parseInt("" + s.charAt(i)) % 2 == (i % 2)) return false;
		}
		return true;
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}