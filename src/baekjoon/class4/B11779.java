package baekjoon.class4;

import java.io.*;
import java.util.*;

/*
플랫폼 : 백준
문제번호 : 11779
문제제목 : 최소비용 구하기 2
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
1. 다익스트라 알고리즘을 돌리고
2. 경로 추적을 위해 이전 노드의 정보를 담는다.
3. 이전 노드 정보를 start 까지 스택에 담고 출력

채점 결과 : 620ms/51616KB
풀이 날짜 : 2021/11/11
*/

public class B11779 {
    static int n, m, start, end;
    static ArrayList<Edge>[] graph;
    static int[] dist, route;

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
            graph[a].add(new Edge(b, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(dist[end] + "\n");

        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.push(end);
            end = route[end];
            if (end == start) {
                stack.push(end);
                break;
            }
        }
        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra() {
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        route = new int[n+1];
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
                    route[nxt.to] = cur.to;
                }
            }
        }
    }
}
