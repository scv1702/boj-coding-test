package Bfs;

import java.io.*;
import java.util.*;

public class N1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        int MAX_SIZE = 100001;
        int[] visited = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            visited[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == K) break;
            if (x-1 >= 0 && visited[x-1] < 0) {
                queue.offer(x-1);
                visited[x-1] = visited[x] + 1;
            }
            if (x+1 < MAX_SIZE && visited[x+1] < 0) {
                queue.offer(x+1);
                visited[x+1] = visited[x] + 1;
            }
            if (2*x < MAX_SIZE && visited[2*x] < 0) {
                queue.offer(2*x);
                visited[2*x] = visited[x] + 1;
            }
        }
        System.out.println(visited[K]);
    }
}