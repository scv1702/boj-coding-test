package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] table = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int answer = seq[0];
        table[0] = seq[0];
        for (int i = 1; i < N; i++) {
            table[i] = Math.max(table[i-1] + seq[i], seq[i]);
            answer = Math.max(answer, table[i]);
        }
        System.out.println(answer);
    }
}