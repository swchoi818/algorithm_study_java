package swea_2930;

import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			Heap hp = new Heap(100000);
//			StringBuilder result = new StringBuilder();
			bw.write("#" + t + " ");
//			int N = sc.nextInt();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int value = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
//				cmd = sc.nextInt();
				value = 0;
				if (cmd == 1) {
//					value = sc.nextInt();
					value = Integer.parseInt(st.nextToken());
					hp.heappush(value);
				} else if (cmd == 2) {
//					result.append(hp.heappop() + " ");
					bw.write(String.valueOf((hp.heappop())));

					bw.write(" ");
				}
			}
			bw.newLine();
//			System.out.println("#" + t + " " + result.toString().trim());
		}
		bw.flush();
		bw.close();
		br.close();
//		sc.close();
	}
}

class Heap {
	private int[] array;
	private int last = -1;

	Heap(int size) {
		this.array = new int[size];
	}

	public int heappop() {
		if (this.last == -1)
			return -1;
		int root = array[0];
		this.array[0] = this.array[last];
		this.array[last] = 0;
		last--;
		this.shiftDown(0);
		return root;
	}

	public void heappush(int num) {
		last++;
		this.array[last] = num;
		this.shiftUp(last);
	}

	private void shiftDown(int idx) {
		int parentIdx = idx;
		int leftIdx = 2 * idx + 1;
		int rightIdx = 2 * idx + 2;

		if (leftIdx <= last && array[leftIdx] > array[parentIdx])
			parentIdx = leftIdx;
		if (rightIdx <= last && array[rightIdx] > array[parentIdx])
			parentIdx = rightIdx;
		if (parentIdx != idx) {
			int pVal = array[parentIdx];
			array[parentIdx] = array[idx];
			array[idx] = pVal;
			shiftDown(parentIdx);
		}
	}

	private void shiftUp(int last) {
		int currentIdx = last;
		int parentIdx = (currentIdx - 1) / 2;
		while (parentIdx >= 0 && array[parentIdx] < array[currentIdx]) {
			int pValue = array[parentIdx];
			array[parentIdx] = array[currentIdx];
			array[currentIdx] = pValue;
			currentIdx = parentIdx;
			parentIdx = (currentIdx - 1) / 2;
		}
	}
}
