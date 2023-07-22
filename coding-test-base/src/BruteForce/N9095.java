package BruteForce;

import java.io.*;

public class N9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int [11];
        dp[1] = 1;
        for (int i = 2; i <= 10; i++) {
            int j = 1;
            while (i - j > 0 && j <= 3) {
                dp[i] += dp[i-j];
                j += 1;
            }
            if (i <= 3) dp[i] += 1;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
