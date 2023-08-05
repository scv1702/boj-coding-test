package Bfs;

import java.io.*;
import java.util.*;

public class N14226 {
    static class Node {
        int emoticon;
        int clipBoard;
        int distance;
        public Node(int emoticon, int clipBoard, int distance) {
            this.emoticon = emoticon;
            this.clipBoard = clipBoard;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine()); 
        int MAX_SIZE = 1002;
        int answer = 0;
        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1, 0, 0));
        visited[1][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int emoticon = node.emoticon;
            int clipBoard = node.clipBoard;
            int distance = node.distance;
            if (emoticon == S) {
                answer = distance;
                break;
            }
            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (emoticon <= 1000 && emoticon + clipBoard <= 1001) {
                if (clipBoard > 0 && !visited[emoticon + clipBoard][clipBoard]) {
                    queue.offer(new Node(emoticon + clipBoard, clipBoard, distance + 1));
                    visited[emoticon + clipBoard][clipBoard] = true;
                }
            }
            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (emoticon - 1 > 0 && !visited[emoticon - 1][clipBoard]) {
                queue.offer(new Node(emoticon - 1, clipBoard, distance + 1));
                visited[emoticon - 1][clipBoard] = true;
            }
            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (emoticon != clipBoard) {
                queue.offer(new Node(emoticon, emoticon, distance + 1));
                visited[emoticon][clipBoard] = true;
            }
        }
        System.out.println(answer);
    }
}