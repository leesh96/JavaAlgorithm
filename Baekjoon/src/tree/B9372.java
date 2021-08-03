package tree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9372
 * 문제제목 : 상근이의 여행
 * 난이도 : 실버 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 그래프 이론, 트리
 *
 * 알고리즘 설명
 * 1. BFS, 최소 신장 트리로 접근
 * 2. 최소 신장 트리의 성질을 이용 -> 정점 수 - 1 이 답
 *
 * 채점 결과 : 692ms/98108KB
 * 풀이 날짜 : 2021/08/03
**/

public class B9372 {
    static int t, n, m;
    static int[][] graph;
    static int[] spanning;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new int[n][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a-1][b-1] = graph[b-1][a-1] = 1;
            }

            spanning = new int[n];
            queue = new LinkedList<>();
            spanning[0] = 1;
            queue.offer(0);
            int count = 0;
            while (!queue.isEmpty()) {
                if (count == n) {
                    break;
                }
                int cur = queue.poll();
                for (int v = 0; v < n; v++) {
                    if (graph[cur][v] == 1 && spanning[v] == 0) {
                        spanning[v] = 1;
                        count++;
                        queue.offer(v);
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
