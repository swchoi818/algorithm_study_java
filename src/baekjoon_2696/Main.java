package baekjoon_2696;

import java.util.*;
import java.io.*;


class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T =  Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int M = Integer.parseInt(br.readLine());
			int[] midNum = new int[M/2 + 1];
			int n = 0;
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minq = new PriorityQueue<>();
			maxq.offer(Integer.parseInt(st.nextToken()));
			midNum[0] = maxq.peek();
			boolean isOdd = false;
			for(int i = 1; i < M; i++) {
				try {
					n = Integer.parseInt(st.nextToken());				
				}
				catch(NoSuchElementException e){
					st = new StringTokenizer(br.readLine());
					n = Integer.parseInt(st.nextToken());
				}
//				System.out.println(n);
				if(n > maxq.peek())
					minq.offer(n);
				else 
					maxq.offer(n);
				if(isOdd) {
					if(maxq.size() - minq.size() > 2) 
						minq.offer(maxq.remove());
					else if(minq.size() - maxq.size() >= 1)
						maxq.offer(minq.remove());
					midNum[i/2] = maxq.peek();
				}
				isOdd = !isOdd;
			}
			bw.write(String.valueOf(M/2 + 1));
			bw.newLine();
			for(int i = 0; i <= M/2; i++) {
				bw.write(String.valueOf(midNum[i]));
				bw.write(" ");
			}
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
