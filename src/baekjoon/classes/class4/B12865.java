package baekjoon.classes.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 12865
문제제목 : 평범한 배낭
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : DP, 배낭문제

알고리즘 설명
0/1 배낭문제 (물건을 쪼갤 수 없기 때문에 DP로 풀어야함)

채점 결과 : 228ms/53832KB
풀이 날짜 : 2021/10/26
*/

public class B12865 {
    static int n, k;
    static int[] weight, value;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        weight = new int[n+1];
        value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[i] = w;
            value[i] = v;
        }
        int result = 0;
        dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(value[i] + dp[i-1][j-weight[i]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
