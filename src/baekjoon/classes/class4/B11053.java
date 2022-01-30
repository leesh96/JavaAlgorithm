package baekjoon.classes.class4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11053
문제제목 : 가장 긴 증가하는 부분 수열
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. LIS 알고리즘

채점 결과 : 168ms/14632KB
풀이 날짜 : 2021/10/19
*/

public class B11053 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
