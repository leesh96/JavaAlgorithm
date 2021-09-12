package algorithmnote.dp;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9252
 * 문제제목 : LCS2
 * 난이도 : 골드 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : DP
 *
 * 알고리즘 설명
 * 1. LCS 알고리즘 사용 최장 공통 부분 수열 구하기
 * 2. 끝에서 올라가면서 dp값이 변하는 시점에 스택에 문자 넣기
 * 3. 마지막에 스택 꺼내면 공통 부분 수열
 *
 * 채점 결과 : 116ms/16128KB
 * 풀이 날짜 : 2021/07/16
**/

public class LCSBackTrackingSample {
    static char[] a, b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine().trim().toCharArray();
        b = br.readLine().trim().toCharArray();
        int n = a.length;
        int m = b.length;

        dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        bw.write(dp[n][m] + "\n");

        if (dp[n][m] != 0) {
            Stack<String> lcs = new Stack<>();
            int i = n;
            int j = m;
            while (dp[i][j] != 0) {
                if (dp[i][j] == dp[i][j-1]) {
                    j--;
                } else if (dp[i][j] == dp[i-1][j]) {
                    i--;
                } else {
                    lcs.add(String.valueOf(a[i-1]));
                    i--;
                    j--;
                }
            }
            while (!lcs.isEmpty()) {
                bw.write(lcs.pop());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
