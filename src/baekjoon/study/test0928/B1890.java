package baekjoon.study.test0928;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1890
문제제목 : 점프
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : DP

알고리즘 설명
1. DFS로 풀 경우 시간초과
2. 각 점에서 오른쪽 또는 아래로 그 수만큼 이동할 수 있으므로
3. 시작점(0, 0)을 1로 만들어 놓고 갈 수 있는 곳에 이전 점의 숫자를 더해준다.
4. 최종적으로 끝 점엔 경로의 수가 저장되어있음

채점 결과 : 152ms/14384KB
풀이 날짜 : 2021/10/04
*/

public class B1890 {
    static int[][] pane;
    static int n;
    static long[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        pane = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pane[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new long[n][n];
        answer[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) continue;
                int nextR = i + pane[i][j];
                int nextC = j + pane[i][j];

                if (0 <= nextR && nextR < n) {
                    answer[nextR][j] += answer[i][j];
                }

                if (0 <= nextC && nextC < n) {
                    answer[i][nextC] += answer[i][j];
                }
            }
        }
        bw.write(answer[n-1][n-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
