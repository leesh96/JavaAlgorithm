package baekjoon.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1167
문제제목 : 트리의 지름
난이도 : 골드 3
제한사항 : 2초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, DFS

알고리즘 설명
1967번과 유사한 문제
루트부터 DFS로 가장 먼 노드를 찾고
해당 노드에서 가장 먼 노드까지 한 번 더 DFS

채점 결과 : 932ms/91548KB
풀이 날짜 : 2021/10/29
*/

public class B1167 {
    static int v;
    static ArrayList<Edge>[] graph;
    static int maxNode, maxDist;
    static boolean[] visit;

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
        v = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());

                if (a == -1) {
                    break;
                }

                int b = Integer.parseInt(st.nextToken());
                graph[num].add(new Edge(a, b));
                graph[a].add(new Edge(num, b));
            }
        }

        maxDist = 0;
        maxNode = 0;
        visit = new boolean[v+1];
        visit[1] = true;
        dfs(1, 0);

        visit = new boolean[v+1];
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
