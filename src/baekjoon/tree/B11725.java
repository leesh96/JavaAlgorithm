package baekjoon.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11725
 * 문제제목 : 트리의 부모 찾기
 * 난이도 : 실버 2
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 그래프 이론, 트리, 그래프 탐색, DFS, BFS
 *
 * 알고리즘 설명
 * 그래프 탐색하면서 부모 갱신 -> 인접 리스트 사용, DFS 사용
 *
 * 채점 결과 : 888ms/72636KB
 * 풀이 날짜 : 2021/08/03
**/

public class B11725 {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        parent = new int[n+1];
        dfs(1, 0);

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int par) {
        parent[start] = par;
        for (int vertex : tree[start]) {
            if (vertex != par) {
                dfs(vertex, start);
            }
        }
    }
}
