import java.io.*;
import java.util.*;

public class N15666 {
    static int N;
    static int M;
    static int[] arr;
    static int[] res;
    static StringBuilder answer;

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                answer.append(res[i]).append(' ');
            }
            answer.append('\n');
            return ;
        }
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= res[Math.max(0, depth-1)] && arr[i] != temp) {
                res[depth] = arr[i];
                temp = res[depth];
                dfs(depth+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        res = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(answer.toString());
    }
}
