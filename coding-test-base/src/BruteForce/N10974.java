package BruteForce;

import java.io.*;
import java.util.*;

public class N10974 {
    static int N;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        output = new int[N];
        br.close();
        for (int i = 0; i < N; i++) {
            output[i] = i+1;
        }
        do {
            for (int m = 0; m < N; m++) {
                sb.append(output[m]).append(" ");
            }
            sb.append('\n');
        } while (nextPermutation());
        System.out.print(sb.toString());
    }

    public static boolean nextPermutation() {
        int i = N-1;
        while (i > 0 && output[i-1] > output[i]) i--;
        if (i <= 0) {
            return false;
        } else {
            int j = N-1;
            while (output[i-1] >= output[j]) j--;
            swap(output, i-1, j);
            j = N-1;
            while (i < j) {
                swap(output, i, j);
                i++; j--;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
