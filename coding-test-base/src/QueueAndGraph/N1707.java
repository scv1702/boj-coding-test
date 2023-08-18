package QueueAndGraph;

import java.io.*;
import java.util.*;

public class N1707 {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph;
    static int[] visited;
    static boolean answer;
    static int V;
    static int E;
    final static int RED = 1;
    final static int BLACK = 2;

    public static void dfs(int u, int color) {
        visited[u] = color;
        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if (visited[v] == color) {
                answer = false;
                return ;
            }
            if (visited[v] == 0) {
                if (color == RED) dfs(v, BLACK);
                else dfs(v, RED);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new int[V];
            graph = new ArrayList<>();
            answer = true;
            for (int j = 0; j < V; j++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            for (int j = 0; j < V; j++) {
                if (visited[j] == 0) 
                    dfs(j, RED);
                if (!answer) break;
            }
            if (answer) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }
}
