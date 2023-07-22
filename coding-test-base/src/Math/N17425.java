package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N17425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int MAX_VALUE = 1000000;
        long[] sieve = new long[MAX_VALUE + 1];
        long[] answer = new long[MAX_VALUE + 1];
        for (int i = 0; i <= MAX_VALUE; i++)
            sieve[i] = 1;
        answer[1] = 1;
        for (int i = 2; i <= MAX_VALUE; i++) {
            for (int j = i; j <= MAX_VALUE; j += i) {
                sieve[j] += (long) i;
            }
            answer[i] = answer[i-1] + sieve[i];
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n]).append('\n');
            
        }
        System.out.print(sb.toString());
    }
}