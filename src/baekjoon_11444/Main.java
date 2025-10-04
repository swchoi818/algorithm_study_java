package baekjoon_11444;

import java.util.Scanner;

class Main {
	final static int MOD = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		System.out.println(fibonacci(N) % MOD);
	}
	
	static long fibonacci(long n) {
		if(n==1)
			return 1;
		long[][] result = new long[1][1];
		long[][] mtr = {{1}, {0}};
		result = multipleMtr(fpowerMtr(n-1), mtr, 2, 1);
		
		return result[0][0];
	}
	
	static long[][] fpowerMtr(long n){
		long[][] result = new long[2][2];
		long[][] fmtr = {{1, 1}, {1, 0}};
		if(n==1)
			return fmtr;
		long[][] divideMtr = fpowerMtr(n/2);
		if(n%2==0)
			result = multipleMtr(divideMtr, divideMtr, 2, 2);
		else
			result = multipleMtr(multipleMtr(divideMtr, divideMtr, 2, 2), fmtr, 2, 2);
		return result;
	}
	
	static long[][] multipleMtr(long[][] mtr1, long[][] mtr2, int n, int m) {
		long[][] result = new long[n][m];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				for(int k = 0; k < n; k++)
					result[i][j] = (result[i][j] + ((mtr1[i][k] * mtr2[k][j]) % MOD)) % MOD;
		
		return result;
	}
}


