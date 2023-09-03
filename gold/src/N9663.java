import java.io.*;
import java.util.*;

public class N9663 {
    static int answer = 0;

    public static boolean promising(int[] board, int N, int depth) {
        // depth 행에 착수한 퀸이 0 ~ depth-1 행의 퀸들의 공격 경로에 위치하는지 검사
        for (int i = 0; i < depth; i++) {
            if (board[i] == board[depth] || Math.abs(board[i] - board[depth]) == depth - i)
                return false;
        }
        return true;
    }

    public static void dfs(int[] board, int N, int depth) {
        if (depth == N) {
            answer += 1;
            return ;
        }
        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if (promising(board, N, depth)) {
                dfs(board, N, depth+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        dfs(board, N, 0);
        System.out.println(answer);
    }
}