import java.io.*;
import java.util.*;

public class N9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int n = a.length();
        int m = b.length();
        int[][] lcs = new int[n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (a.charAt(i) == b.charAt(j)) {
                    lcs[i][j] = 1 + lcs[i+1][j+1];
                } else {
                    lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
                }
            }
        }
        System.out.println(lcs[0][0]);
    }
}