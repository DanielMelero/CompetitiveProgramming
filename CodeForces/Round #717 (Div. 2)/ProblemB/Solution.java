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
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) list.add(in.nextInt());
		found = false;
		xorAllPositions(list);

		if (found) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}

	private void xorAllPositions(ArrayList<Integer> list) {
		if (isEqual(list)) {
			found = true;
		}
		if (found) return;
		if (list.size() == 2) return;

		ArrayList<Integer> newList;
		int value1, value2;
		for (int i = 0; i < list.size() - 1; i++) {
			if (found) break;
			newList = new ArrayList<>(list);
			value1 = list.get(i);
			value2 = list.get(i+1);
			newList.remove(i);
			newList.remove(i);
			newList.add(i, value1 ^ value2);	
			xorAllPositions(newList);
		}
	}

	private boolean isEqual(ArrayList<Integer> list) {
		Integer compare = null;
		for (Integer val : list) {
			if (compare == null) {
				compare = val;
			} else if (compare - val != 0) {
				return false;
			}
		}
		return true;
	}

	private void debugShowArrayListContent(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}