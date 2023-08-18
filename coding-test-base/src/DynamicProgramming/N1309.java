package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N+1][3];
        final int LEFT = 0;
        final int RIGHT = 1;
        final int CLEAR = 2;
        table[1][LEFT] = 1;
        table[1][RIGHT] = 1;
        table[1][CLEAR] = 1;
        for (int i = 2; i <= N; i++) {
            table[i][LEFT] = (table[i-1][RIGHT] + table[i-1][CLEAR]) % 9901;
            table[i][RIGHT] = (table[i-1][LEFT] + table[i-1][CLEAR]) % 9901;
            table[i][CLEAR] = (table[i-1][LEFT] + table[i-1][RIGHT] + table[i-1][CLEAR]) % 9901;
        }
        System.out.println((table[N][LEFT] + table[N][RIGHT] + table[N][CLEAR]) % 9901);
    }
}