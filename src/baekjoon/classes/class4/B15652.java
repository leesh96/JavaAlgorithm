package baekjoon.classes.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15652
문제제목 : N과 M (4)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 백트래킹
2. 중복 조합 구하기

채점 결과 : 220ms/19924KB
풀이 날짜 : 2021/10/18
*/

public class B15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(new int[m], 0, 1);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] ans, int depth, int cur) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = cur; i <= n; i++) {
            ans[depth] = i;
            dfs(ans, depth + 1, i);
        }
    }
}
