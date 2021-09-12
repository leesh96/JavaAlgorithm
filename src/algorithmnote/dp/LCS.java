package algorithmnote.dp;

import java.io.*;

public class LCS {
    // 최장 공통 부분 수열(문자열)
    // i. ABCDHEF와 BCDEF의 최장 공통 부분 수열은 BCDEF, 최장 공통 부분 문자열은 BCD라는 차이가 있다.
    static int[][] dp;
    static String a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        int n = a.length();
        int m = b.length();
        dp = new int[n+1][m+1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 최장 공통 부분 수열 코드
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
                
                // 최장 공통 부분 문자열 코드
                /*if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }*/
            }
        }
    }
}
