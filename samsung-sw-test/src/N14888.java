import java.io.*;
import java.util.*;

public class N14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int[] nums, char[] opcodes, char[] res, boolean[] visited, int depth) {
        if (depth == res.length) {
            int i = 1;
            int j = 0;
            int val = nums[0];
            while (i < nums.length && j < res.length) {
                switch (res[j]) {
                    case '+': val = val + nums[i]; break;
                    case '-': val = val - nums[i]; break;
                    case 'x': val = val * nums[i]; break;
                    case '/': val = val / nums[i]; break;
                }
                i++; j++;
            }
            max = Math.max(max, val);
            min = Math.min(min, val);
            return ;
        }

        for (int i = 0; i < opcodes.length; i++) {
            if (!visited[i]) {
                res[depth] = opcodes[i];
                visited[i] = true;
                dfs(nums, opcodes, res, visited, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        char[] opcodes = new char[N-1];
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                opcodes[idx++] = "+-x/".charAt(i);
            }
        }
        boolean[] visited = new boolean[N-1];
        char[] res = new char[N-1];
        dfs(nums, opcodes, res, visited, 0);
        System.out.printf("%d\n%d\n", max, min);
    }
}