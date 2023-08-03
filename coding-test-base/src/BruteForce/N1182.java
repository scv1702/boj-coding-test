package BruteForce;

import java.io.*;
import java.util.*;

public class N1182 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] set = new int[N];
        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < N; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < (1 << N); i++) {
            int s = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    s += set[j]; 
                }    
            }
            if (s == S) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}