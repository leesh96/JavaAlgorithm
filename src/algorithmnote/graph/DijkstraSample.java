package algorithmnote.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraSample {
    // 백준 1753번 최단 경로 문제
    static int v, e, k;
    static int[] dist;
    static PriorityQueue<node> q;
    static ArrayList<node>[] graph;
    static final int INF = 1000000000;

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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[v+1];
        Arrays.fill(dist, INF);
        graph = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new node(v, w));
        }

        q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        dist[k] = 0;
        q.offer(new node(k, 0));

        while (!q.isEmpty()) {
            node current = q.poll();
            if (dist[current.to] < current.weight) {
                continue;
            }
            for (node n : graph[current.to]) {
                int cost = current.weight + n.weight;
                if (cost < dist[n.to]) {
                    dist[n.to] = cost;
                    q.offer(new node(n.to, cost));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (i == k) {
                bw.write(0 + "\n");
                continue;
            }
            if (dist[i] < INF) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
