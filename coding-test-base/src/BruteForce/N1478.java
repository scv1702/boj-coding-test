package BruteForce;

import java.io.*;

public class N1478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int digitLength = 0;
        long answer = 0;
        while (temp > 0) {
            digitLength += 1;
            temp = temp / 10;
        }
        for (int i = 1; i <= digitLength - 1; i++) {
            answer += 9 * ((long) Math.pow(10, i - 1)) * i;
        }
        if (digitLength > 1)
            answer += (N - ((long) Math.pow(10, digitLength - 1)) + 1) * digitLength;
        else
            answer += N * digitLength;
        System.out.println(answer);
    }
}