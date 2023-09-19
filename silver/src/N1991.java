import java.io.*;
import java.util.*;

public class N1991 {
    public static void preorder(String[] tree, int i, StringBuilder sb) {
        if (i < tree.length && tree[i] != null) {
            sb.append(tree[i]);
            preorder(tree, 2*i, sb);
            preorder(tree, 2*i+1, sb);
        }
    }

    public static void inorder(String[] tree, int i, StringBuilder sb) {
        if (i < tree.length && tree[i] != null) {
            inorder(tree, 2*i, sb);
            sb.append(tree[i]);
            inorder(tree, 2*i+1, sb);
        }
    }

    public static void postorder(String[] tree, int i, StringBuilder sb) {
        if (i < tree.length && tree[i] != null) {
            postorder(tree, 2*i, sb);
            postorder(tree, 2*i+1, sb);
            sb.append(tree[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tree = new String[(int) Math.pow(2, N)];
        tree[1] = "A";
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            for (int j = 1; j < tree.length; j++) {
                if (tree[j] != null && tree[j].equals(parent)) {
                    if (!".".equals(left)) tree[2*j] = left;
                    if (!".".equals(right)) tree[2*j+1] = right;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        preorder(tree, 1, sb);
        sb.append('\n');
        inorder(tree, 1, sb);
        sb.append('\n');
        postorder(tree, 1, sb);
        sb.append('\n');
        System.out.print(sb.toString());
    }
}