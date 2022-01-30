package baekjoon.simulation.silver3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10974
문제제목 : 모든 순열
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
순열 구하는 알고리즘 -> 백트래킹

채점 결과 : 296ms/29292KB
풀이 날짜 : 2022/01/30
*/

public class B10974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dfs(new int[n],  0, new boolean[n+1]);

        bw.close();
        br.close();
    }

    static void dfs(int[] arr, int depth, boolean[] visit) throws IOException {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) sb.append(i).append(" ");
            bw.write(sb.append("\n").toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(arr, depth + 1, visit);
                visit[i] = false;
            }
        }
    }
}
