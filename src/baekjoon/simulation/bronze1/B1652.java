package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1652
문제제목 : 누울 자리를 찾아라
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 가로 세로 문자열의 각 자리 순차 탐색

채점 결과 : 140ms/14468KB
풀이 날짜 : 2021/12/04
*/

public class B1652 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        String[] room = new String[n];
        for (int i = 0; i < n; i++) {
            room[i] = br.readLine();
        }

        int horizon = 0;
        int vertical = 0;
        for (int i = 0; i < n; i++) {
            int hozCnt = 0;
            int vertCnt = 0;
            for (int j = 0; j < n; j++) {
                char curHoz = room[i].charAt(j);
                if (curHoz == '.') hozCnt++;
                if (curHoz == 'X' || j == n - 1) {
                    if (hozCnt >= 2) horizon++;
                    hozCnt = 0;
                }

                char curVert = room[j].charAt(i);
                if (curVert == '.') vertCnt++;
                if (curVert == 'X' || j == n - 1) {
                    if (vertCnt >= 2) vertical++;
                    vertCnt = 0;
                }
            }
        }

        bw.write(String.format("%d %d", horizon, vertical));
        bw.flush();
        bw.close();
        br.close();
    }
}
