package algorithmnote.graph;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KruskalSample {
    // 백준 1922번 네트워크 연결 문제
    static class edge {
        int from;
        int to;
        int cost;

        public edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m;
    static PriorityQueue<edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        parent = new int[n+1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.offer(new edge(a, b, c));
        }

        int result = 0;
        while (!edges.isEmpty()) {
            edge cur = edges.poll();
            if (find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                result += cur.cost;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
