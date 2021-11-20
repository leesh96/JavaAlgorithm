package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1063
문제제목 : 킹
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
구현

채점 결과 : 140ms/14524KB
풀이 날짜 : 2021/11/20
*/

public class B1063 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        n = Integer.parseInt(st.nextToken());

        int kingR = king.charAt(1) - '1';
        int kingC = king.charAt(0) - 'A';
        int stoneR = stone.charAt(1) - '1';
        int stoneC = stone.charAt(0) - 'A';

        for (int i = 0; i < n; i++) {
            String order = br.readLine();

            int nextKR = kingR;
            int nextKC = kingC;
            int nextSR = stoneR;
            int nextSC = stoneC;

            if (order.equals("R")) {
                nextKC++;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC++;
                }
            } else if (order.equals("L")) {
                nextKC--;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC--;
                }
            } else if (order.equals("B")) {
                nextKR--;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSR--;
                }
            } else if (order.equals("T")) {
                nextKR++;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSR++;
                }
            } else if (order.equals("RT")) {
                nextKC++;
                nextKR++;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC++;
                    nextSR++;
                }
            } else if (order.equals("LT")) {
                nextKC--;
                nextKR++;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC--;
                    nextSR++;
                }
            } else if (order.equals("RB")) {
                nextKC++;
                nextKR--;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC++;
                    nextSR--;
                }
            } else if (order.equals("LB")) {
                nextKC--;
                nextKR--;

                if (nextKR == stoneR && nextKC == stoneC) {
                    nextSC--;
                    nextSR--;
                }
            }

            if (nextKR < 0 || nextKR > 7 || nextKC < 0 || nextKC > 7 || nextSR < 0 || nextSR > 7 || nextSC < 0 || nextSC > 7) {
                continue;
            }

            kingR = nextKR;
            kingC = nextKC;
            stoneR = nextSR;
            stoneC = nextSC;
        }

        bw.write(String.format("%c%c\n", kingC+'A', kingR+'1'));
        bw.write(String.format("%c%c", stoneC+'A', stoneR+'1'));

        bw.flush();
        bw.close();
        br.close();
    }
}
