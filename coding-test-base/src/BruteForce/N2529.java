package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class N2529 {
    static int k;
    static char[] inequalitySymbols;
    static boolean[] visited;
    static StringBuilder sb;
    static String min;
    static String max;

    public static void dfs(int depth, int prev) {
        if (depth == k) {
            String s = sb.toString();
            if (min == null) {
                min = s;
            }
            if (max == null) {
                max = s;
            }
            if (s.compareTo(min) < 0) {
                min = s;
            }
            if (s.compareTo(max) > 0) {
                max = s;
            }
            return ;
        }
        if (inequalitySymbols[depth] == '>') {
            for (int i = 0; i < prev; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sb.append(i);
                    dfs(depth + 1, i);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }     
            }
        }
        if (inequalitySymbols[depth] == '<') {
            for (int i = prev + 1; i < 10; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sb.append(i);
                    dfs(depth + 1, i);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequalitySymbols = new char[k];
        visited = new boolean[10];
        for (int i = 0; i < k; i++) {
            inequalitySymbols[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i < 10; i++) {
            sb = new StringBuilder();
            visited[i] = true;
            sb.append(i);
            dfs(0, i);
            visited[i] = false;
        }
        System.out.println(max);
        System.out.println(min);
    }
}