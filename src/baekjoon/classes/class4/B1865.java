package baekjoon.classes.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1865
문제제목 : 웜홀
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 벨만-포드

알고리즘 설명
벨만 포드 알고리즘

채점 결과 : 456ms/47448KB
풀이 날짜 : 2021/10/30
*/

public class B1865 {
    static int tc, n, m, w;
    static ArrayList<Edge>[] graph;
    static int[] dist;

    static final int INF = Integer.MAX_VALUE;

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
        tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[s].add(new Edge(e, w));
                graph[e].add(new Edge(s, w));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[s].add(new Edge(e, -w));
            }
            dist = new int[n+1];

            bw.write(bellmanFord() ? "YES\n" : "NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean isUpdate = false;

        for (int i = 1; i < n; i++) {
            isUpdate = false;

            for (int j = 1; j <= n; j++) {
                for (Edge e : graph[j]) {
                    if (dist[e.to] > dist[j] + e.weight) {
                        dist[e.to] = dist[j] + e.weight;
                        isUpdate = true;
                    }
                }
            }

            if (!isUpdate) {
                break;
            }
        }

        if (isUpdate) {
            for (int i = 1; i <= n; i++) {
                for (Edge e : graph[i]) {
                    if (dist[e.to] > dist[i] + e.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
