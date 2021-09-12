package algorithmnote.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LowestCommonAncestorSample {
    static int n, m;
    static int[] depth;
    static boolean[] visit;
    static int[][] parent;
    static ArrayList<Integer>[] tree;
    static final int MAX_DEPTH = 18;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        depth = new int[n+1];
        visit = new boolean[n+1];
        parent = new int[n+1][MAX_DEPTH];
        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 1, 1);

        for (int i = 1; i < MAX_DEPTH; i++) {
            for (int j = 1; j <= n; j++) {
                int par = parent[j][i-1];
                parent[j][i] = parent[par][i-1];
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(lca(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur, int par, int dep) {
        if (visit[cur]) {
            return;
        }
        visit[cur] = true;
        depth[cur] = dep;
        parent[cur][0] = par;
        for (int c : tree[cur]) {
            dfs(c, cur, dep + 1);
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = MAX_DEPTH - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = MAX_DEPTH - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
