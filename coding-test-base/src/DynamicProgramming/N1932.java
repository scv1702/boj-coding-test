package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N+1][N];
        int[][] table = new int[N+1][N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        table[1][0] = triangle[1][0];
        for (int i = 2; i <= N; i++) {
            table[i][0] = triangle[i][0] + table[i-1][0];
            for (int j = 1; j < N; j++) {
                table[i][j] = triangle[i][j] + Math.max(table[i-1][j-1], table[i-1][j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (table[N][i] > answer) answer = table[N][i];
        }
        System.out.println(answer);
    }
}