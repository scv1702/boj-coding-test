package BruteForce;

import java.io.*;
import java.util.*;

public class N1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int START_CHANNEL = 100;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10]; // true if broken
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int answer = Integer.MAX_VALUE;
        int channel = 0;
        if (N != START_CHANNEL) {
            for (channel = 0; channel <= 1000000; channel++) {
                boolean isBroken = false;
                int buttonClickCount = 0;
                if (channel >= 10) {
                    int temp = channel;
                    while (temp > 0) {
                        buttonClickCount += 1;
                        if (broken[temp % 10]) {
                            isBroken = true;
                            break;
                        } else {
                            temp /= 10;
                        }
                    }
                } else {
                    isBroken = broken[channel];
                    if (!isBroken) buttonClickCount = 1;
                }
                if (channel == START_CHANNEL || !isBroken) {
                    if (channel == START_CHANNEL) buttonClickCount = 0;
                    answer = Math.min(answer, buttonClickCount + Math.abs(N - channel));
                }
            }
        } else {
            answer = 0;
        }
        System.out.println(answer);
    }    
}