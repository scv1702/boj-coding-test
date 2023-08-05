package BruteForce;

import java.io.*;
import java.util.*;

public class N10972 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] output = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            output[i] = Integer.parseInt(st.nextToken());
        }
        int i = N-1;
        while (i > 0 && output[i-1] > output[i]) i--;
        if (i <= 0) {
            sb.append(-1);
        } else {
            int j = N-1;
            while (output[i-1] >= output[j]) j--;
            swap(output, i-1, j);
            j = N-1;
            while (i < j) {
                swap(output, i, j);
                i++; j--;
            }
            for (int m = 0; m < N; m++) {
                sb.append(output[m]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
