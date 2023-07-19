package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N6588 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int MAX_VALUE = 1000000;
        boolean[] sieve = new boolean[MAX_VALUE + 1];
        sieve[0] = sieve[1] = true;
        
        for (int i = 2; i * i <= MAX_VALUE; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= MAX_VALUE; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int n = 0;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            int a = 0;
            for (a = 3; a <= n/2; a += 2) {
                if (!sieve[a] && !sieve[n-a]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(n-a).append('\n');
                    break;
                }
            }
            if (a > n/2) {
                System.out.println("Goldbach's conjecture is wrong.");
                return ;
            }
        }
        System.out.print(sb.toString());
    }
}