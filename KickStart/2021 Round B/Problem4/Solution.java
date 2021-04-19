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

	long[][] roads;
	int weight;

	public void solve(int c, Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int q = in.nextInt();
		roads = new long[n-1][4];
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < 4; j++) {
				roads[i][j] = in.nextLong();
			}
		}
		String res = "";
		for (int i = 0; i < q; i++) {
			int city = in.nextInt();
			weight = in.nextInt();

			List<Long> tolls = new ArrayList<>();
			tolls = findOne(city, tolls);

			res += greatestCommonDivisor(tolls.toArray(new Long[tolls.size()])) + " ";
		}



		this.print(c, res);
	}

	private List<Long> findOne(long city, List<Long> tolls) {
		if (city == 1) return tolls;
		for (long[] road : roads) {
			if (road[0] == city && road[1] < city) {
				if (weight >= road[2]) tolls.add(road[3]);
				if (road[1] == 1) return tolls;
				tolls = findOne(road[1], tolls);
				if (tolls != null) return tolls;
			} else if (road[1] == city && road[0] < city) {
				if (weight >= road[2]) tolls.add(road[3]);
				if (road[0] == 1) return tolls;
				tolls = findOne(road[0], tolls);
				if (tolls != null) return tolls;
			}
		}
		return null;
	}

	private long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
  
    private long greatestCommonDivisor(Long tolls[]) {
		if (tolls == null) return 0;
		if (tolls.length == 0) return 0;
        long res = tolls[0];
        for (int i = 1; i < tolls.length; i++) {
            res = gcd(tolls[i], res);
		}
        return res;
    }

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}