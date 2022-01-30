package baekjoon.classes.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 17070
문제제목 : 파이프 옮기기 1
난이도 : 골드 5
제한사항 : 1초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, DP

알고리즘 설명
1. DFS로 각 파이프 형태에 맞게 조건 탐색
2. DP로도 풀이 가능 (주석처리)

채점 결과 : 332ms/17372KB
풀이 날짜 : 2021/11/02
*/

public class B17070 {
    static int n, count;
    static int[][] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*int[][][] dp = new int[n+1][n+1][3];
        dp[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (home[i-1][j-1] == 1) continue;
                dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];

                if (i == 1) continue;
                dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];

                if (home[i-2][j-1] == 1 || home[i-1][j-2] == 1) continue;
                dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        int answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        bw.write(answer + "\n");*/

        dfs(0, 1, 0);
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int shape) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }

        if (shape == 0) {
            // 가로
            int nextR;
            int nextC;

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nextR = r;
                    nextC = c + 1;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && home[nextR][nextC] == 0) {
                        dfs(nextR, nextC, 0);
                    }
                } else {
                    nextR = r + 1;
                    nextC = c + 1;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                        if (check(r, c, nextR, nextC)) {
                            dfs(nextR, nextC, 2);
                        }
                    }
                }
            }
        } else if (shape == 1) {
            // 세로
            int nextR;
            int nextC;

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nextR = r + 1;
                    nextC = c;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && home[nextR][nextC] == 0) {
                        dfs(nextR, nextC, 1);
                    }
                } else {
                    nextR = r + 1;
                    nextC = c + 1;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                        if (check(r, c, nextR, nextC)) {
                            dfs(nextR, nextC, 2);
                        }
                    }
                }
            }
        } else {
            // 대각선
            int nextR;
            int nextC;

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nextR = r + 1;
                    nextC = c;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && home[nextR][nextC] == 0) {
                        dfs(nextR, nextC, 1);
                    }
                } else if (i == 1) {
                    nextR = r + 1;
                    nextC = c + 1;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                        if (check(r, c, nextR, nextC)) {
                            dfs(nextR, nextC, 2);
                        }
                    }
                } else {
                    nextR = r;
                    nextC = c + 1;
                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && home[nextR][nextC] == 0) {
                        dfs(nextR, nextC, 0);
                    }
                }
            }
        }
    }

    static boolean check(int r, int c, int nr, int nc) {
        for (int i = r; i <= nr; i++) {
            for (int j = c; j <= nc; j++) {
                if (home[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
