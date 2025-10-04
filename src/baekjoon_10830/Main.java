package baekjoon_10830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	final static int MOD = 1000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B  = Long.parseLong(st.nextToken());
		int[][] A = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = mtrPower(A, N, B);
		
		for(int i = 0;i < N;i++) {
			for(int j = 0; j < N; j++) {
				bw.write(String.valueOf((result[i][j]) % MOD) + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int[][] mtrPower(int[][] mtr, int n, long b) {
		int[][] result = new int[n][n];
		if(b == 1) {
			return mtr;
		}
		int[][] divideMtr = mtrPower(mtr, n, b/2);
		
		if(b%2==0) 
			result = mtrMultiple(divideMtr, divideMtr, n);
		else
			result = mtrMultiple(mtrMultiple(divideMtr, divideMtr, n), mtr, n);

		return result;
	}
	
	static int[][] mtrMultiple(int[][] mtr1, int[][] mtr2, int n) {
		int[][] result = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					result[i][j] = (result[i][j] + ((mtr1[k][j] * mtr2[i][k]) % MOD)) % MOD;
		
		return result;
	}

}
