package Bfs;

import java.io.*;
import java.util.*;

public class N13549 {
    static class Node {
        int location;
        int time;

        public Node (int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        int MAX_SIZE = 100001;
        boolean[] visited = new boolean[MAX_SIZE];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(N, 0));
        visited[N] = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int location = node.location;
            int time = node.time;
            if (location == K) {
                System.out.println(time);
                break;
            }
            if (2*location < MAX_SIZE && !visited[2*location]) {
                queue.offer(new Node(2*location, time));
                visited[2*location] = true;
            }
            if (location-1 >= 0 && !visited[location-1]) {
                queue.offer(new Node(location-1, time+1));
                visited[location-1] = true;
            }
            if (location+1 < MAX_SIZE && !visited[location+1]) {
                queue.offer(new Node(location+1, time+1));
                visited[location+1] = true;
            }
        }
    }
}