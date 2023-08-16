package QueueAndGraph;

import java.io.*;
import java.util.*;

public class N13023 {
    static boolean answer;
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void dfs(int u, int depth) {
        if (depth == 5) {
            answer = true;
            return ;
        }
        visited[u] = true;
        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if (!visited[v]) {
                dfs(v, depth + 1);
            }
        }
        visited[u] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = false;
        visited = new boolean[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (answer) break;
        }
        if (answer) System.out.println(1);
        else System.out.println(0);
    }
}