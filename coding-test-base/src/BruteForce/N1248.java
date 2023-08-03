package BruteForce;

import java.io.*;
import java.util.*;

public class N1248 {
    static int n;
    static int[] answer;
    static int[][] s;
    static StringBuilder sb = new StringBuilder();

    public static boolean check(int idx) {
        int sum = 0;
        boolean flag = true;
        for (int i = idx; i < n; i++) {
            sum += answer[i];
            if (s[idx][i] > 0 && sum > 0) continue;
            if (s[idx][i] == 0 && sum == 0) continue;
            if (s[idx][i] < 0 && sum < 0) continue;
            flag = false;
            break;
        }
        return flag;
    }

    public static void recur(int idx) {
        if (sb.length() >= 2*n) return ;
        if (idx == -1) {
            for (int i = 0; i < n; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        if (s[idx][idx] > 0) {
            for (int i = 1; i <= 10; i++) {
                answer[idx] = i;
                if (check(idx)) recur(idx - 1);

            }
        } else if (s[idx][idx] < 0) {
            for (int i = 0; i >= -10; i--) {
                answer[idx] = i;
                if (check(idx)) recur(idx - 1);
            }
        } else {
            answer[idx] = 0;
            recur(idx - 1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        answer = new int[n];
        int k = 0;
        String line = br.readLine();
        br.close();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = line.charAt(k++);
                if (c == '-') s[i][j] = -1;
                if (c == '+') s[i][j] = 1;
            }
        }
        recur(n-1);
        System.out.print(sb.toString());
    }    
}