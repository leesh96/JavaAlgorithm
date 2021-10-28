package baekjoon.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1967 {
    static int n;
    static boolean[] visit;
    static ArrayList<Edge>[] graph;
    static int maxNode, maxDist;

    static class Edge {
        int to, weight;

        public Edge(int t, int w) {
            this.to = t;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        maxDist = 0;
        maxNode = 0;
        visit = new boolean[n+1];
        visit[1] = true;
        dfs(1, 0);

        visit = new boolean[n+1];
        visit[maxNode] = true;
        dfs(maxNode, 0);

        bw.write(maxDist + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur, int cost) {
        if (maxDist < cost) {
            maxDist = cost;
            maxNode = cur;
        }

        for (Edge nxt : graph[cur]) {
            if (!visit[nxt.to]) {
                visit[nxt.to] = true;
                dfs(nxt.to, cost + nxt.weight);
            }
        }
    }
}
