package QueueAndGraph;

import java.io.*;
import java.util.*;

public class N1707 {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean answer;
    static Set<Integer> red;
    static Set<Integer> black;
    static int V;
    static int E;

    public static void dfs(int u, boolean color) {
        visited[u] = true;
        if (color) red.add(u);
        else black.add(u);
        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if (color && red.contains(v) || !color && black.contains(v)) {
                answer = false;
                return ;
            }
            if (color) black.add(v);
            else red.add(v);
            if (!visited[v]) {
                dfs(v, !color);
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
            visited = new boolean[V];
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
            red = new HashSet<>();
            black =  new HashSet<>();
            for (int j = 0; j < V; j++) {
                if (!visited[j]) 
                    dfs(j, true);
                if (!answer) break;
            }
            if (answer) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }
}
