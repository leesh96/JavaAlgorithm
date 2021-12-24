package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 3023
문제제목 : 마술사 이민혁
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 처음 입력 받을 때 좌우 대칭인 부분, 상하 대칭인 부분, 대각 대칭인 부분을 모두 채우고
2. 에러를 만들어주고
3. 출력

채점 결과 : 136ms/14548KB
풀이 날짜 : 2021/12/24
*/

public class B3023 {
    static int r, c;
    static char[][] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        card = new char[r*2][c*2];
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                card[i][j] = temp.charAt(j);
                int reverseC = (c * 2) - 1 - j;
                card[i][reverseC] = card[i][j];
                int reverseR = (r * 2) - 1 - i;
                card[reverseR][j] = card[i][j];
                card[reverseR][reverseC] = card[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int errR = Integer.parseInt(st.nextToken()) - 1;
        int errC = Integer.parseInt(st.nextToken()) - 1;
        if (card[errR][errC] == '#') card[errR][errC] = '.';
        else card[errR][errC] = '#';

        for (int i = 0; i < 2 * r; i++) {
            for (int j = 0; j < 2 * c; j++) {
                bw.write(card[i][j] + "");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
