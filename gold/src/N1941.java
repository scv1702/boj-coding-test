import java.io.*;
import java.util.*;

public class N1941 {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int answer;

    public static void dfs(Set<Integer> set, boolean[] visited, int n) {
        visited[n] = true;
        for (int[] dir: dirs) {
            int ni = n / 5 + dir[0];
            int nj = n % 5 + dir[1];
            if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && set.contains(ni * 5 + nj) && !visited[ni * 5 + nj]) {
                dfs(set, visited, ni * 5 + nj);
            }
        }
    }

    public static boolean isAdjacent(int[] res) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            set.add(res[i]);
        }
        boolean[] visited = new boolean[25];
        dfs(set, visited, res[0]);
        int cnt = 0;
        for (int n = 0; n < 25; n++) {
            if (visited[n]) cnt += 1;
        }
        return cnt >= 7;
    }

    public static boolean isDominant(char[][] seats, int[] res) {
        int s = 0;
        for (int i = 0; i < 7; i++) {
            if (seats[res[i] / 5][res[i] % 5] == 'S') s += 1;
        }
        return s >= 4;
    }

    public static void combination(char[][] seats, boolean[] visited, int[] res, int depth, int start) {
        if (depth >= 7) {
            if (isDominant(seats, res) && isAdjacent(res)) {
                answer += 1;
            }            
            return ;
        }
        for (int i = start; i < 25; i++) {
            res[depth] = i;
            combination(seats, visited, res, depth+1, i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] seats = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                seats[i][j] = line.charAt(j);
            }
        }
        boolean[] visited = new boolean[25];
        int[] res = new int[7];
        combination(seats, visited, res, 0, 0);
        System.out.println(answer);
    }
}