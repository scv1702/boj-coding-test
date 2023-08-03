package BruteForce;

import java.io.*;
import java.util.*;

public class N1759 {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    static int L;
    static int C;
    static String[] chars;
    static String s = "aeiou";

    public static void dfs(int idx, int depth, int vowels, int consonants) {
        if (depth == L && vowels >= 1 && consonants >= 2) {
            answer.append(sb.toString()).append('\n');
            return ;
        }

        for (int i = idx; i < C; i++) {
            sb.append(chars[i]);
            if ("aeiou".contains(chars[i])) {
                dfs(i + 1, depth + 1, vowels + 1, consonants);
            } else {
                dfs(i + 1, depth + 1, vowels, consonants + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chars = new String[C]; 
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken();
        }
        Arrays.sort(chars);
        dfs(0, 0, 0, 0);
        System.out.print(answer.toString());
    }
}