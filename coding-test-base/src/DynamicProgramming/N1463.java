package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(N+1, 4)];
        dp[1] = 0;
        dp[2] = dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            int ans = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                ans = Math.min(ans, 1 + dp[i / 3]);
            }
            if (i % 2 == 0) {
                ans = Math.min(ans, 1 + dp[i / 2]);
            }
            ans = Math.min(ans, 1 + dp[i - 1]);
            dp[i] = ans;
        }
        System.out.println(dp[N]);
    }
}