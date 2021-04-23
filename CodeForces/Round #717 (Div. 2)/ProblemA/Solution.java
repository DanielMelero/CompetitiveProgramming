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
		int k = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) array[i] = in.nextInt();

		
		for (int i = 0; i < k; i++) {
			Integer subtractIndex = null;
			for (int j = 0; j < n - 1; j++) {
				if (array[j] - 1 >= 0) {
					subtractIndex = j;
					array[j]--;
					break;
				}
			}
			if (subtractIndex == null) break;
			for (int j = n - 1; j >= 0; j--) {
				if (j != subtractIndex) {
					array[j]++;
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) System.out.print(array[i] + " ");
		System.out.println();
	}
}