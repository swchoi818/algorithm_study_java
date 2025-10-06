package baekjoon_2805;

import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] treeHights = new int[N];
		int high = 0;
		int low = 0;
		int result = 0;
		for(int i = 0; i < N; i++) {
			treeHights[i] = Integer.parseInt(st.nextToken());
			if(high < treeHights[i])
				high = treeHights[i];
		}
		while(low <= high) {
			int mid = (low + high) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++)
				if(mid < treeHights[i])
					sum += (treeHights[i] - mid);
			if(sum >= M) {
				result = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		System.out.println(result);
		br.close();
	}
}
