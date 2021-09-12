package algorithmnote.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BellmanFordSample {
    // 백준 3860번 타임머신 문제
    static int n, m;
    static long[] dist;
    static ArrayList<node>[] graph;
    static final long INF = (long) 1e18;

    static class node {
        int to;
        int weight;

        public node(int t, int w) {
            this.to = t;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n+1];
        Arrays.fill(dist, INF);
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new node(b, c));
        }

        dist[1] = 0;
        boolean isCycle = false;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (node adj : graph[j]) {
                    if (dist[j] != INF && dist[adj.to] > dist[j] + adj.weight) {
                        dist[adj.to] = dist[j] + adj.weight;
                        if (i == (n - 1)) {
                            isCycle = true;
                        }
                    }
                }
            }
        }

        if (isCycle) {
            bw.write("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
