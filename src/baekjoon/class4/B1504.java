package baekjoon.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1504
문제제목 : 특정한 최단 경로
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
1. 두 경로 1 -> v1 -> v2 -> n과 1 -> v2 -> v1 -> n에 대해서 다익스트라 진행
2. 두 경로 중 작은 값이 정답
3. 만약 두 경로 모두 초기화가 안된경로라면 -1 출력

채점 결과 : 692ms/69492KB
풀이 날짜 : 2021/11/04
*/

public class B1504 {
    static int n, e, v1, v2;
    static ArrayList<Edge>[] graph;
    static int[] dist;

    static final int INF = 200000000;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];

        int route1 = 0;
        route1 += dijkstra(1, v1);
        route1 += dijkstra(v1, v2);
        route1 += dijkstra(v2, n);

        int route2 = 0;
        route2 += dijkstra(1, v2);
        route2 += dijkstra(v2, v1);
        route2 += dijkstra(v1, n);

        if (route1 >= INF && route2 >= INF) {
            bw.write("-1");
        } else {
            bw.write(Math.min(route1, route2) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (Edge nxt : graph[cur.to]) {
                int cost = dist[cur.to] + nxt.weight;
                if (cost < dist[nxt.to]) {
                    dist[nxt.to] = cost;
                    queue.offer(new Edge(nxt.to, cost));
                }
            }
        }

        return dist[end];
    }
}
