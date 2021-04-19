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
		int length = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		byte[] bytes = in.next().getBytes();
		String res = "";
		int ant = 0;
		byte pre = 0;
		for (byte b : bytes) {
			if (b > pre) ant++;
			else ant = 1;
			pre = b;
			res += ant + " ";
		}
		this.print(c, res);
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}