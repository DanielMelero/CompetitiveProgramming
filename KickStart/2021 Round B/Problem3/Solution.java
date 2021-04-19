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
		long z = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
		
		long root = (long)Math.ceil(Math.sqrt((double)z));
		long top;
		long bot;
		if (isPrime(root)) {
			top = root;
		} else {
			top = nextTopPrime(root);
		}
		bot = nextBotPrime(root);
		while (top*bot > z) {
			top = bot;
			bot = nextBotPrime(top);
		} 

		this.print(c, "" + top*bot);
	}
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
         
        if (n % 2 == 0 || n % 3 == 0) return false;
         
        for (int i = 5; i * i <= n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
        return true;
    }
    
	private long nextTopPrime(long n) {
		long l = n;
        boolean found = false;
        while (!found) {
            l++;
            if (isPrime(l)) found = true;
        }
        return l;
    }

	private long nextBotPrime(long n) {
		long l = n;
        boolean found = false;
        while (!found) {
            l--;
            if (isPrime(l)) found = true;
        }
        return l;
	}

	private void print(int c, String res) {
		System.out.println("Case #" + c + ": " + res);
	}

	private void print(int c, int res) {
		this.print(c, "" + res);
	}
}