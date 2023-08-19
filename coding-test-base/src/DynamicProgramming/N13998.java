package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N13998 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] table = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            if (seq[i] < 0 && seq[i] < min) {
                min = seq[i];
                minIdx = i;
            }
        }
        if (minIdx >= 0) seq[minIdx] = 0;
        int answer = seq[0];
        table[0] = seq[0];
        for (int i = 1; i < N; i++) {
            table[i] = Math.max(table[i-1] + seq[i], seq[i]);
            answer = Math.max(answer, table[i]);
        }
        System.out.println(answer);
    }
}