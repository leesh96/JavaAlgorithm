package baekjoon.class4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 9251
문제제목 : LCS
난이도 : 골드 5
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
LCS 알고리즘

채점 결과 : 164ms/18524KB
풀이 날짜 : 2021/10/24
*/

public class B9251 {
    static String a, b;
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine();
        b = br.readLine();
        n = a.length();
        m = b.length();
        dp = new int[n+1][m+1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
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
