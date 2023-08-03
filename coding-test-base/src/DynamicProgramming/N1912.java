package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = seq[0];
        int s = seq[0];
        for (int i = 1; i < N; i++) {
            if (s < s + seq[i]) {
                s += seq[i];
            } else {
                s = seq[i];
            }
            
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N-1]);
    }
}