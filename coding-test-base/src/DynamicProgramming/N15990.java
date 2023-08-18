package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N15990 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int TABLE_SIZE = 100001;
        int MOD = 1000000009;
        long[][] table = new long[TABLE_SIZE][4];
        table[1][1] = 1;
        table[2][2] = 1;
        table[3][1] = 1;
        table[3][2] = 1;
        table[3][3] = 1;
        for (int i = 4; i < TABLE_SIZE; i++) {
            table[i][1] = (table[i-1][2] + table[i-1][3]) % MOD;;
            table[i][2] = (table[i-2][1] + table[i-2][3]) % MOD;
            table[i][3] = (table[i-3][1] + table[i-3][2]) % MOD;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((table[n][1] + table[n][2] + table[n][3]) % MOD).append('\n');
        }
        System.out.print(sb.toString());
    }
}