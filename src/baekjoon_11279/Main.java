package baekjoon_11279;

import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			
			if(x==0) {
				if(pq.size() > 0) {	
					bw.write(String.valueOf(pq.poll()));
				}
				else {
					bw.write("0");
				}
				bw.newLine();
			}
			else {
				pq.add(x);
			}
		}
		
		sc.close();
		bw.flush();
		bw.close();
	}

}
