package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] prices = new int[N+1][3];
        int[][] table = new int[N+1][3];
        final int R = 0;
        final int G = 1;
        final int B = 2;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices[i][R] = Integer.parseInt(st.nextToken());
            prices[i][G] = Integer.parseInt(st.nextToken());
            prices[i][B] = Integer.parseInt(st.nextToken());
        }
        table[1][R] = prices[1][R];
        table[1][G] = prices[1][G];
        table[1][B] = prices[1][B];
        for (int i = 2; i <= N; i++) {
            table[i][R] = Math.min(prices[i][R] + table[i-1][G], prices[i][R] + table[i-1][B]);
            table[i][G] = Math.min(prices[i][G] + table[i-1][R], prices[i][G] + table[i-1][B]);
            table[i][B] = Math.min(prices[i][B] + table[i-1][R], prices[i][B] + table[i-1][G]);
        }
        System.out.println(Math.min(table[N][R], Math.min(table[N][G], table[N][B])));
    }
}