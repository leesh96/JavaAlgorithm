package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10219
문제제목 : Meats On The Grill
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 애드 혹, 구성적

알고리즘 설명
1. 그냥 불판을 좌우반전 시키면 정답

채점 결과 : 132ms/14152KB
풀이 날짜 : 2021/12/20
*/

public class B10219 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] pane = new char[n][m];
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m; j++) {
                    pane[i][j] = input.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bw.write(pane[i][m-1-j] + "");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
