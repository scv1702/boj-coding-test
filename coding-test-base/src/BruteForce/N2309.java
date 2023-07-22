package BruteForce;

import java.io.*;
import java.util.*;

public class N2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dwarfs = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }
        sum -= 100;
        Arrays.sort(dwarfs);  
        int i = 0;
        int j = 8;
        while (i < j) {
            if (dwarfs[i] + dwarfs[j] == sum) break;
            if (dwarfs[i] + dwarfs[j] > sum) j--;
            if (dwarfs[i] + dwarfs[j] < sum) i++;
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
                sb.append(dwarfs[k]).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}