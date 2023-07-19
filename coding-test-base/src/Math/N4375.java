package Math;

import java.io.*;

public class N4375 {
    public static boolean isComposedOfOne(long n) {
        while (n > 0) {
            if (n % 10 != 1) return false;
            n /= 10;
        }
        return true;
    }
    
    public static int getDigitLength(long n) {
        int digitLength = 0;
        while (n > 0) {
            n /= 10;
            digitLength++;
        }
        return digitLength;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != "" && !line.isEmpty()) {
            long n = Long.parseLong(line);
            int digitLength = getDigitLength(n);
            if (!isComposedOfOne(n)) {     
                long start = Long.parseLong("1".repeat(++digitLength));
                while (start % n != 0) {
                    start = (start * 10 + 1) % n;
                    digitLength++;
                }
            }
            sb.append(digitLength).append('\n');
        }
        System.out.print(sb.toString());
    }
}