package baekjoon.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1238
문제제목 : 파티
난이도 : 골드 3
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
1. 정방향 그래프와 입력의 역방향 그래프 2개를 받는다.
2. x 점에 대해서 정방향 그래프의 최단경로, 역방향 그래프의 최단경로를 모두 구함 -> 다익스트라 사용
3. 두 최단경로의 합이 가장 큰 사람의 소요시간이 정답

채점 결과 : 208ms/19124KB
풀이 날짜 : 2021/11/09
*/

public class B1238 {
    static int n, m, x;
    static int[] dist, reverseDist;
    static ArrayList<Edge>[] graph, reverseGraph;

    static final int INF = 987654321;

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
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        reverseGraph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, t));
            reverseGraph[b].add(new Edge(a, t));
        }

        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[x] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        queue.offer(new Edge(x, 0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (cur.weight > dist[cur.to]) {
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

        reverseDist = new int[n+1];
        Arrays.fill(reverseDist, INF);
        reverseDist[x] = 0;
        queue.offer(new Edge(x, 0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (cur.weight > reverseDist[cur.to]) {
                continue;
            }

            for (Edge nxt : reverseGraph[cur.to]) {
                int cost = reverseDist[cur.to] + nxt.weight;
                if (cost < reverseDist[nxt.to]) {
                    reverseDist[nxt.to] = cost;
                    queue.offer(new Edge(nxt.to, cost));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;

            if (dist[i] != INF && reverseDist[i] != INF) {
                answer = Math.max(answer, dist[i] + reverseDist[i]);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
