package BruteForce;

import java.io.*;
import java.util.*;

public class N6603 {
    static StringBuilder sb;
    static int[] arr;
    static int[] output;

    public static void combination(int n, int r, int idx, int depth) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = idx; i < n; i++) {
            output[depth] = arr[i];
            combination(n, r, i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String line = br.readLine();
        while (line.charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            output = new int[6];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(k, 6, 0, 0);
            sb.append('\n');
            line = br.readLine();
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }
}
