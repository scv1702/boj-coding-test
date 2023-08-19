package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[1000000+1][2];
        table[2][0] = 1;
        table[2][1] = 1;
        if (N >= 3) {
            table[3][0] = 1;
            table[3][1] = 1;
            for (int i = 4; i <= N; i++) {
                table[i][0] = N;
            }
            for (int i = 3; i < N; i++) {
                int[] ids = { i+1, i*2, i*3 };
                for (int idx: ids) {
                    if (idx <= N && table[idx][0] > table[i][0] + 1) {
                        table[idx][0] = table[i][0] + 1;
                        table[idx][1] = i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(table[N][0]).append('\n');
        int ptr = N;
        while (ptr >= 1) {
            sb.append(ptr).append(' ');
            ptr = table[ptr][1];
        }
        System.out.println(sb.toString());
    }
}