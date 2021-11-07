package baekjoon.class4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14938
문제제목 : 서강그라운드
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 다익스트라, 플로이드-와샬

알고리즘 설명
1. 플로이드-와샬 알고리즘을 사용하여 모든 쌍 최단경로를 구한다.
2. 각 시작정점(i)에 대해 다른 정점까지의 최단경로가 탐색범위 이내라면 아이템 수 +
3. 각 시작정점에 대해 최대로 탐색할 수 있는 아이템 수 갱신

채점 결과 : 168ms/15028KB
풀이 날짜 : 2021/11/07
*/

public class B14938 {
    static int n, m, r;
    static int[] items;
    static int[][] graph;

    static final int MAX = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        graph = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a][b] = l;
            graph[b][a] = l;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int item = items[i];
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (graph[i][j] <= m) {
                    item += items[j];
                }
            }
            answer = Math.max(answer, item);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
