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

	HashMap<Integer, Integer[]> diffToLength;

	public void solve(int c, Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int[] array = new int[n];
		for (int i = 0; i < n; i++) array[i] = in.nextInt();
		int[] copy = new int[n];
		diffToLength = new HashMap<>();

		for (int i = 0; i < n - 1; i++) {
			System.arraycopy(array, 0, copy, 0, n);
			int diff = copy[i] - copy[i+1];
			if (diffToLength.containsKey(diff)) {
				Integer[] coordinates = diffToLength.get(diff);
				if (i<coordinates[1]) continue;
			}
			int j;
			boolean changed = false;
			for (j = i + 1; j < n - 1; j++) {
				if (copy[j] - copy[j+1] == diff) continue;
				else if (!changed) {
					copy[j + 1] = copy[j] - diff;
					changed = true;
					continue;
				} else {
					break;
				}
			}
			if (diffToLength.containsKey(diff)) {
				Integer[] val = diffToLength.get(diff);
				if (val[1] - val[0] + 1 <= j - i + 1) {
					Integer[] l = {i, j};
					diffToLength.put(diff, l);
				}
			} else {
				Integer[] l = {i, j};
				diffToLength.put(diff, l);
			}
		}
		int best = 0;
		for (Map.Entry<Integer, Integer[]> e : diffToLength.entrySet()) {
			if (best < e.getValue()[1] - e.getValue()[0] + 1) {
				best = e.getValue()[1] - e.getValue()[0] + 1;
			} 
		}

		this.print(c, best);
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}