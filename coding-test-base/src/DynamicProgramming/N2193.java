package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N2193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[Math.max(3, N+1)][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;
        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][0] + dp[N][1]);
    }
}