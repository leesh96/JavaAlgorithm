package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14582
문제제목 : 오늘도 졌다
난이도 : 실버 5
제한사항 : 1초/64MB
알고리즘 분류 : 구현

알고리즘 설명
1. n회초 -> n회말 순서대로 점수 비교
2. boolean 변수에 상태 저장

채점 결과 : 120ms/14212KB
풀이 날짜 : 2022/01/10
*/

public class B14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] je = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            je[i] = Integer.parseInt(st.nextToken());
        }

        int[] gu = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            gu[i] = Integer.parseInt(st.nextToken());
        }

        int jScore = 0;
        int gScore = 0;
        boolean isJeWins = false;
        boolean isReverseDefeat = false;
        for (int i = 0; i < 9; i++) {
            jScore += je[i];
            if (jScore > gScore) {
                isJeWins = true;
            }

            gScore += gu[i];
            if (isJeWins && jScore < gScore) {
                isReverseDefeat = true;
                break;
            }
        }

        if (isReverseDefeat) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
