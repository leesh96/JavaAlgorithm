package baekjoon.classes.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1149
문제제목 : RGB거리
난이도 : 실버 1
제한사항 : 0.5초/128MB
알고리즘 분류 : DP

알고리즘 설명
1. 인접한 색끼리 칠하면 안되는 DP
2. 각 경로의 모든 최소 값을 구한 후 마지막에 최솟값 찾아서 출력

채점 결과 : 140ms/14724KB
풀이 날짜 : 2021/10/20
*/

public class B1149 {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[n+1][3];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        bw.write(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
