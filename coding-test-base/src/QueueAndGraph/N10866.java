package QueueAndGraph;

import java.io.*;
import java.util.*;

public class N10866 {
    static interface Deque {
        void pushFront(Integer i);
        void pushBack(Integer i);
        Integer popFront();
        Integer popBack();
        int size();
        boolean empty();
        Integer front();
        Integer back();
    }
    
    static class ArrayDeque implements Deque {
        static final int CAPACITY = 10000;
        int[] array;
        int size;
        int front;
        int rear;

        public ArrayDeque() {
            this.array = new int[CAPACITY];
            this.size = 0;
            this.front = 0;
            this.rear = 0;
        }

        public void pushFront(Integer i) {
            array[front] = i;
            front = (front - 1 + CAPACITY) % CAPACITY;
            size++;
        }

        public void pushBack(Integer i) {
            rear = (rear + 1) % CAPACITY;
            array[rear] = i;
            size++;
        }

        public Integer popFront() {
            if (empty()) return -1;
            front = (front + 1) % CAPACITY;
            size--;
            return array[front];

        }

        public Integer popBack() {
            if (empty()) return -1;
            int res = array[rear];
            rear = (rear - 1 + CAPACITY) % CAPACITY;
            size--;
            return res;
        }

        public int size() {
            return size;
        }

        public boolean empty() {
            return size == 0;
        }

        public Integer front() {
            if (empty()) return -1;
            return array[(front + 1) % CAPACITY];
        }

        public Integer back() {
            if (empty()) return -1;
            return array[rear];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque deque = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            int operand = 0;
            switch (opcode) {  
                case "push_front":
                    operand = Integer.parseInt(st.nextToken());
                    deque.pushFront(operand);
                    break;
                case "push_back":
                    operand = Integer.parseInt(st.nextToken());
                    deque.pushBack(operand);
                    break;
                case "pop_front":
                    sb.append(deque.popFront()).append('\n');
                    break;
                case "pop_back":
                    sb.append(deque.popBack()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(deque.empty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(deque.front()).append('\n');
                    break;
                case "back":
                    sb.append(deque.back()).append('\n');
                    break;
                default: break;
            }
        }
        System.out.print(sb.toString());
    }    
}
