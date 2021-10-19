package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 9465
문제제목 : 스티커
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. 각 열에 대해 최대 스티커 수 DP
2. 스티커를 뜯을 수 있는 경우를 따져보면 위쪽 배열에선 왼쪽 아래 대각선과 왼쪽 2칸 전 아래 대각선에서 뜯는 경우
3. 아래쪽 배열에선 왼쪽 위 대각선과 왼쪽 2칸 전 위 대각선에서 뜯는 경우가 있음

채점 결과 : 992ms/134904KB
풀이 날짜 : 2021/10/19
*/

public class B9465 {
    static int t, n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[n+1][2];
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + arr[i][0];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + arr[i][1];
            }
            bw.write(Math.max(dp[n][0], dp[n][1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
