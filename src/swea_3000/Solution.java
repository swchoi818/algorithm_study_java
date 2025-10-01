package swea_3000;

import java.util.*;

public class Solution {
	final static int MOD = 20171109;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Heap maxHq = new Heap(sc.nextInt());
			Heap minHq = new Heap(true);
			long result = 0;
			for (int i = 0; i < N; i++) {
				int num = 0;
				for (int j = 0; j < 2; j++) {
					num = sc.nextInt();
					if (maxHq.getRoot() >= num)
						maxHq.heappush(num);
					else if (maxHq.getRoot() < num)
						minHq.heappush(num);
				}
				if(maxHq.getSize() - minHq.getSize() >= 2)
					minHq.heappush(maxHq.heappop());
				else if(minHq.getSize() > maxHq.getSize())
					maxHq.heappush(minHq.heappop());
				result = (result + maxHq.getRoot()) % MOD;
			}
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}

class Heap {
	private ArrayList<Integer> numArray = new ArrayList<>();
    private boolean isMin = false;
    Heap(int num) {
        this.numArray.add(num);
    }
    
    Heap(int num, boolean isMin) {
        this.isMin = isMin;
        if(this.isMin)
            num *= -1;
        this.numArray.add(num);
    }
    
    Heap(boolean isMin){
        this.isMin = isMin;
    }
    
    public int heappop() {
        if(this.numArray.isEmpty())
            return -1;
        int root = numArray.get(0);
        int lastIdx = numArray.size() - 1;
        this.numArray.set(0, numArray.get(lastIdx));
        this.numArray.set(lastIdx, root);        
        this.numArray.remove(lastIdx);
        this.shiftDown(0);
        if(this.isMin)
            root *= -1;
        return root;
    }
    
    public void heappush(int num) {
        if(this.isMin)
            num *= -1;
        this.numArray.add(num);
        this.shiftUp(this.numArray.size() -1);
    }
    
    
    private void shiftDown(int idx) {
        int length = this.numArray.size();
        int nextIdx = idx;
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;
        
        if(leftIdx < length && numArray.get(leftIdx) > numArray.get(nextIdx))
        	nextIdx = leftIdx;
        if(rightIdx < length && numArray.get(rightIdx) > numArray.get(nextIdx))
        	nextIdx = rightIdx;
        if(nextIdx != idx) {
        	int nextVal = numArray.get(nextIdx);
        	numArray.set(nextIdx, numArray.get(idx));
        	numArray.set(idx, nextVal);
        	shiftDown(nextIdx);
        }
    }
    
    private void shiftUp(int last) {
        int currentIdx = last;
        int parentIdx = (currentIdx - 1) / 2;
        while(parentIdx >= 0 && numArray.get(parentIdx) < numArray.get(currentIdx)) {
            int temp = numArray.get(parentIdx);
            numArray.set(parentIdx, numArray.get(currentIdx));
            numArray.set(currentIdx, temp);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }
    
    public int getRoot() {
        return numArray.get(0);
    }
    
    public int getSize() {
        return numArray.size();
    }
}