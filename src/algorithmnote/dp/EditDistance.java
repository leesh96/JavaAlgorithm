package algorithmnote.dp;

import java.io.*;

public class EditDistance {
    static String a, b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        int n = a.length();
        int m = b.length();
        dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
            }
        }

        System.out.println(dp[n][m] + "");
    }
}
