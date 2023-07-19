package Math;

import java.io.*;
import java.util.StringTokenizer;

public class N1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = n;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x <= 1) {
                answer--;
            }
            for (int j = 2; j <= Math.sqrt(x); j++) {
                if (x % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}