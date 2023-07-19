package Math;

import java.io.*;
import java.util.StringTokenizer;

public class N1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int divisor = Integer.parseInt(st.nextToken());
            if (divisor < min) min = divisor;
            if (divisor > max) max = divisor;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min * max).append('\n');
        System.out.print(sb.toString());
    }
}