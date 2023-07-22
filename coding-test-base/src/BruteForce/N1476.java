package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class N1476 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 1 <= E <= 15
        int S = Integer.parseInt(st.nextToken()); // 1 <= S <= 28
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 19
        int answer = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        while (e != E || s != S || m != M) {
            answer += 1;
            e = e + 1 > 15 ? (e + 1) % 15 : e + 1;
            s = s + 1 > 28 ? (s + 1) % 28 : s + 1;
            m = m + 1 > 19 ? (m + 1) % 19 : m + 1;
        }
        System.out.println(answer);
    }
}