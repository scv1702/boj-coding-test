package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N15988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int TABLE_SIZE = 1000001;
        long[] table = new long[TABLE_SIZE];
        table[1] = 1;
        table[2] = 2;
        table[3] = 4;
        for (int i = 4; i < TABLE_SIZE; i++) {
            table[i] = (table[i-1] + table[i-2] + table[i-3]) % 1000000009;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(table[n]).append('\n');
        }
        System.out.print(sb.toString());
    }
}