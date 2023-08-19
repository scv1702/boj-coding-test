package DynamicProgramming;

import java.io.*;
import java.util.*;

public class N2156 {
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] wine = new int[N+1];
    int[] table = new int[N+1];
    for (int i = 1; i <= N; i++) {
        wine[i] = Integer.parseInt(br.readLine());
    }
    table[1] = wine[1];
    if (N >= 2) {
        table[2] = table[1] + wine[2];
        for (int i = 3; i <= N; i++) {
            table[i] = wine[i] + Math.max(wine[i-1] + table[i-3], table[i-2]);
            table[i] = Math.max(table[i], table[i-1]);
        }
    }
    System.out.println(table[N]);
    }
}
