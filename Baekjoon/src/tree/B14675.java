package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 14675
 * 문제제목 : 단절점과 단절선
 * 난이도 : 골드 5
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 그래프 이론, 트리
 *
 * 알고리즘 설명
 * 트리에서,
 * 정점에 연결된 간선수가 2개 이상이면 단절점
 * 모든 간선은 단절선 (트리는 사이클이 없기 때문에)
 * 그래프에서의 단절점과 단절선은 좀 다름
 *
 * 채점 결과 : 636ms/76040KB
 * 풀이 날짜 : 2021/08/03
**/

public class B14675 {
    static int n, q;
    static ArrayList<Integer>[] tree;
    static edge[] edges;

    static class edge {
        int from, to;

        public edge(int f, int t) {
            this.from = f;
            this.to = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        edges = new edge[n];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
            edges[i] = new edge(a, b);
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean result = false;
            if (t == 1) {
                if (tree[k].size() > 1) {
                    result = true;
                }
            } else {
                result = true;
            }
            bw.write((result ? "yes" : "no") + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
