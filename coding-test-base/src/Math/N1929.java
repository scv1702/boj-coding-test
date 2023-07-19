package Math;

import java.io.*;
import java.util.StringTokenizer;

public class N1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] sieve = new boolean[n + 1];
        sieve[0] = sieve[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!sieve[i]) {
                for (int j = i*i; j <= n; j += i) {
                    sieve[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!sieve[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}