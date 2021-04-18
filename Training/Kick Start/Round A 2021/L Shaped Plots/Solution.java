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
		ArrayList<Integer[]> Csegs = new ArrayList<>(); 
		ArrayList<Integer[]> Rsegs = new ArrayList<>();
		int rows = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int columns = in.nextInt();
		int[][] grid = new int[rows][columns];
		int onesCount;
		
		for (int x = 0; x < rows; x++) {
			onesCount = 0;
			for (int y = 0; y < columns; y++) {
				//add and check segments in columns
				int value = in.nextInt();
				grid[x][y] = value;
				if (value == 1) {
					onesCount++;
				} else {
					if (onesCount >= 2) {
						Integer[] addition = {onesCount, x, y - onesCount, x, y - 1};
						Csegs.add(addition);
					}
					onesCount = 0;
				}
			}

			if (onesCount >= 2) {
				Integer[] addition = {onesCount, x, columns - onesCount, x, columns - 1};
				Csegs.add(addition);
			}
		}
		
		for (int y = 0; y < columns; y++) {
			onesCount = 0;
			for (int x = 0; x < rows; x++) {
				//check segments in rows
				if (grid[x][y] == 1) {
					onesCount++;
				} else {
					if (onesCount >= 2) {
						Integer[] addition = {onesCount, x - onesCount, y, x - 1, y};
						Rsegs.add(addition);
					}
					onesCount = 0;
				}
			}

			if (onesCount >= 2) {
				Integer[] addition = {onesCount, rows - onesCount, y, rows - 1, y};
				Rsegs.add(addition);
			}
		}

		int count = 0;
		boolean sameEndPoint ;
		for (Integer[] rowSegment : Rsegs) {
			for(Integer[] columnSegment : Csegs) {
				sameEndPoint = false;
				for(int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						if (rowSegment[1+2*i] == columnSegment[1+2*j] 
								&& rowSegment[2+2*i] == columnSegment[2+2*j]) {
							count += internalShapes(rowSegment[0], columnSegment[0]);
							sameEndPoint = true;
						}
					}
				}
				if (!sameEndPoint) {
					//column inside row
					for(int i = 0; i < 2; i++) {
						int cy = columnSegment[2+2*i];
						int cx = columnSegment[1+2*i];
						if (cy == rowSegment[2] && inside(cx, rowSegment[1], rowSegment[3])) {
							for (int j = 0; j < 2; j++) {
								int l = Math.abs(cx - rowSegment[1+2*j]) + 1;
								count += internalShapes(columnSegment[0], l);
							}
						}
					}

					//row inside column
					for(int i = 0; i < 2; i++) {
						int ry = rowSegment[2+2*i];
						int rx = rowSegment[1+2*i];
						if (rx == columnSegment[1] && inside(ry, columnSegment[2], columnSegment[4])) {
							for (int j = 0; j < 2; j++) {
								int l = Math.abs(ry - columnSegment[2+2*j]) + 1;
								count += internalShapes(rowSegment[0], l);
							}
						}
					}
				}
			}
		}
		

		this.print(c, count);
	}

	private int[] getMinMax(int x, int y) {
		int max;
		int min;
		if (x>y) {
			max = x;
			min = y;
		} else {
			max = y;
			min = x;
		}
		int[] res = {min, max};
		return res;
	}

	private boolean inside(int a, int b, int c) {
		int[] m = getMinMax(b, c);

		return (a<m[1]) && (a>m[0]);
	}

	private int internalShapes(int x, int y) {
		int[] m = getMinMax(x, y);
		int count = 0;

		for (int i = 0; m[1] - i >= 2; i++) {
			for (int j = 0; m[0]-j >= 2; j++) {
				if (m[1]-i == 2*(m[0]-j) || (m[1]-i)*2 == m[0]-j) {
					count++;
				}
			}
		}
		return count;
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}