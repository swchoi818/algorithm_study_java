package baekjoon_2252;

import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] precede = new int[N + 1];
		precede[0] = -1;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			precede[v] += u;
		}
		boolean isEnd = false;
		while(!isEnd) {
			isEnd = true;
			for(int i = 1; i <= N; i++) {
				if(precede[i]==0) {
					bw.append(String.valueOf(i));
					for(int j = 0; j < graph.get(i).size(); j++) {
						precede[graph.get(i).get(j)] -= i;
					}
					precede[i] = -1;
					isEnd = false;
				}
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
