package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1236
문제제목 : 성 지키기
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 각 행과 열에 대해서 경비원이 존재하는지 파악, 경비원이 없는 행과 열 카운트
2. 경비원이 없는 행 수와 경비원이 없는 열 중 더 큰 값이 답

채점 결과 : 132ms/14324KB
풀이 날짜 : 2021/12/07
*/

public class B1236 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] castle = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                castle[i][j] = (input.charAt(j) == 'X');
            }
        }

        int rowCnt = 0;
        int colCnt = 0;
        for (int i = 0; i < n; i++) {
            boolean hasX = false;
            for (int j = 0; j < m; j++) {
                if (castle[i][j]) {
                    hasX = true;
                    break;
                }
            }
            if (!hasX) rowCnt++;
        }

        for (int i = 0; i < m; i++) {
            boolean hasX = false;
            for (int j = 0; j < n; j++) {
                if (castle[j][i]) {
                    hasX = true;
                    break;
                }
            }
            if (!hasX) colCnt++;
        }

        bw.write((Math.max(rowCnt, colCnt)) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
