package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N16194 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = prices[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.min(prices[i], Math.min(dp[i-1] + prices[1], );
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}