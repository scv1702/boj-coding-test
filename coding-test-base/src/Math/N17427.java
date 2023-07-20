package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N17427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sieve = new long[n + 1];
        long answer = 1;
        for (int i = 0; i <= n; i++)
            sieve[i] = 1;
        sieve[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                sieve[j] += (long) i;
            }
            answer += sieve[i];
        }
        System.out.println(answer);
    }
}

/*
 * 자연수 K의 배수는 항상 K를 약수로 가진다는 점을 이용헤 O(N)으로도 풀 수 있다.
 * long answer = 0;
 * for (int i = 1; i <= N; i++) {
 *     answer += (N / i) * i;
 * }
 */