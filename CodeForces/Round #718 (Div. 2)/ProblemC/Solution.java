import java.util.*;
import java.io.*;

/**
 * @author Daniel Melero
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Solution solution = new Solution();
		solution.solve(in);
	}

	public void solve(Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int[] diagonal = new int[n];
		for (int i = 0; i < n; i++) diagonal[i] = in.nextInt();
		int[] count = new int[n];
		Arrays.fill(count, 1);
		ArrayList<Integer[]> board = new ArrayList<>();
		for (int i = 0; i < n-1; i++) {
			board.add(new Integer[n-i-1]);
			for (int j = 0; j < board.get(i).length; j++) {
				if (i==0) {
					if (j == 0) {
						if (!isComplete(diagonal[j], count)) {
							board.get(i)[j] = diagonal[j];
							count[diagonal[j]-1]++;
						} else if (!isComplete(diagonal[j+1], count)) {
							board.get(i)[j] = diagonal[j+1];
							count[diagonal[j+1]-1]++;
						} else {
							board.get(i)[j] = 0;
						}
					} else {
						if (!isComplete(diagonal[j+1], count)) {
							board.get(i)[j] = diagonal[j+1];
							count[diagonal[j+1]-1]++;
						} else if (!isComplete(diagonal[j], count)) {
							board.get(i)[j] = diagonal[j];
							count[diagonal[j]-1]++;
						} else {
							board.get(i)[j] = 0;
						}
					}
				} else {
					if (j == 0) {
						if (!isComplete(board.get(i-1)[j], count)) {
							board.get(i)[j] = board.get(i-1)[j];
							count[board.get(i)[j]-1]++;
						} else if (!isComplete(board.get(i-1)[j+1], count)) {
							board.get(i)[j] = board.get(i-1)[j+1];
							count[board.get(i)[j]-1]++;
						} else {
							board.get(i)[j] = 0;
						}
					} else {
						if (!isComplete(board.get(i-1)[j+1], count)) {
							board.get(i)[j] = board.get(i-1)[j+1];
							count[board.get(i)[j]-1]++;
						} else if (!isComplete(board.get(i-1)[j], count)) {
							board.get(i)[j] = board.get(i-1)[j];
							count[board.get(i)[j]-1]++;
						} else {
							board.get(i)[j] = 0;
						}
					}
				}
				
			}
		}

		if (!checkBoard(count)) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(board.get(i-j-1)[j] + " ");
				}
				System.out.println(diagonal[i]);
			}
		}

	}

	private boolean checkBoard(int[] count) {
		for(int c = 0; c < count.length; c++) {
			if (count[c] != c+1) return false;
		}
		return true;
	}

	private boolean isComplete(int value, int[] count) {
		if (value == 0) return true;
		return count[value-1] == value;
	}

	private void debugShowArray(int[] array) {
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}