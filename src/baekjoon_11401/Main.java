package baekjoon_11401;

import java.util.*;

class Main {

    final static int MOD = 1000000007;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long result = (((factorialMod(N) * power(factorialMod(K), MOD - 2)) % MOD) * power(factorialMod(N - K), MOD - 2)) % MOD;

        System.out.println(result);
        
        sc.close();
    }

    public static long factorialMod(int num) {
    	long result = 1;
        for (int i = 1; i <= num; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    public static long power(long base, long p) {
        if (base == 1 || p == 0)
            return 1;
        if (p == 1)
            return base % MOD;

        long result = 0;
        long divNum = power(base, p / 2);

        if (p % 2 == 0)
            result = (divNum * divNum) % MOD;
        else if(p % 2 == 1)
            result = (((divNum * divNum)% MOD) * base) % MOD;

        return result;
    }
}
