package baekjoon.classes.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15650
문제제목 : N과 M (2)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 백트래킹
2. 조합 구하는 문제

채점 결과 : 152ms/15812KB
풀이 날짜 : 2021/10/18
*/

public class B15650 {
    static int n, m;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];

        dfs(new int[m], 0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] cur, int depth, int idx) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(cur[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = idx + 1; i <= n; i++) {
            cur[depth] = i;
            dfs(cur, depth + 1, i);
        }
    }
}
