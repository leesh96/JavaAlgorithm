package baekjoon.classes.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1916
문제제목 : 최소비용 구하기
난이도 : 골드 5
제한사항 : 0.5초/128MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
1. 다익스트라 알고리즘 문제

채점 결과 : 564ms/51024KB
풀이 날짜 : 2021/10/22
*/

public class B1916 {
    static int n, m, start, end;
    static int[] dist;
    static ArrayList<edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class edge {
        int to, weight;

        public edge(int t, int w) {
            this.to = t;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new edge(b, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        PriorityQueue<edge> pq = new  PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new edge(start, 0));

        while (!pq.isEmpty()) {
            edge cur = pq.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (edge nxt : graph[cur.to]) {
                int cost = cur.weight + nxt.weight;
                if (dist[nxt.to] > cost) {
                    dist[nxt.to] = cost;
                    pq.offer(new edge(nxt.to, cost));
                }
            }
        }

        bw.write(dist[end] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
