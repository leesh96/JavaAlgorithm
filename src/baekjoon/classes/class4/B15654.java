package baekjoon.classes.class4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15654
문제제목 : N과 M (5)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 백트래킹
2. 순열 구하기

채점 결과 : 424ms/37124KB
풀이 날짜 : 2021/10/18
*/

public class B15654 {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n];
        Arrays.sort(arr);

        dfs(new int[m], 0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] ans, int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ans[depth] = arr[i];
                dfs(ans, depth + 1);
                visit[i] = false;
            }
        }
    }
}
