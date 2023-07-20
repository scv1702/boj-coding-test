package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N17427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sieve = new long[n + 1];
        long answer = 1;
        for (int i = 0; i <= n; i++)
            sieve[i] = 1;
        sieve[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                sieve[j] += (long) i;
            }
            answer += sieve[i];
        }
        System.out.println(answer);
    }
}