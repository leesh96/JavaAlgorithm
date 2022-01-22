package baekjoon.simulation.silver4;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 10994
문제제목 : 별 찍기 - 19
난이도 : 실버 4
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 재귀

알고리즘 설명
1. 별을 찍는 정사각형 한변의 길이 = 4(n-1) + 1
2. 재귀로 별을 바깥쪽 정사각형 테두리에 한번씩 그려준다.
3. 별-공백-별 순으로 정사각형 테두리가 찍힘
4. 정사각형을 구현한 2차원 배열 출력

채점 결과 : 176ms/15308KB
풀이 날짜 : 2022/01/22
*/

public class B10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int len = 4 * (n - 1) + 1;
        char[][] stars = new char[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(stars[i], ' ');
        }
        draw(stars, 0, len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                bw.write(stars[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void draw(char[][] stars, int cur, int len) {
        for (int i = cur; i < len; i++) {
            stars[cur][i] = '*';
            stars[len-1][i] = '*';
            stars[i][cur] = '*';
            stars[i][len-1] = '*';
        }

        if (len == 1) return;

        draw(stars, cur + 2, len - 2);
    }
}
