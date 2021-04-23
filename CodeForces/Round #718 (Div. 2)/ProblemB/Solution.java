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

	public boolean found;

	public void solve(Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int m = in.nextInt();
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			paths.add(new ArrayList<>());
			for (int j = 0; j < m; j++) {
				paths.get(i).add(in.nextInt());
			}
			Collections.sort(paths.get(i));
		}
		int[][] res = new int[n][m];
		int index;
		int value;
		int minValue = 0;
		for (int r = 0; r < m; r++) {
			index = 0;
			for (int p = 0; p < n; p++) {
				value = paths.get(p).get(0);
				if (index == p) {
					minValue = value;
				} else if (value < minValue) {
					index = p;
					minValue = value;
				}
			}
			paths.get(index).remove(0);
			res[index][r] = minValue;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] == 0) {
					res[i][j] = paths.get(i).get(0);
					paths.get(i).remove(0);
				}
			}
		}

		for (int[] re : res) {
			for (int r : re) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}

	private void debugShowArrayListContent(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}