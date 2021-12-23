package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 3035
문제제목 : 스캐너
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. for 문의 반복 범위 조절

채점 결과 : 136ms/14480KB
풀이 날짜 : 2021/12/23
*/

public class B3035 {
    static int r, c, zr, zc;
    static char[][] article;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        zr = Integer.parseInt(st.nextToken());
        zc = Integer.parseInt(st.nextToken());

        article = new char[r][c];

        for (int i = 0; i < r; i++) {
            article[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int k = 0; k < zr; k++) {
                for (int j = 0; j < c; j++) {
                    for (int l = 0; l < zc; l++) {
                        bw.write(article[i][j]);
                    }
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
