package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[Math.max(4, n+1)];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb.toString());
    }
}