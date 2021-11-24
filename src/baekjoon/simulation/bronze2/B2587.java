package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 2587
문제제목 : 대표값2
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 사칙연산

알고리즘 설명
1. 입력 받으면서 합 구하기 -> 평균
2. 정렬 수 가운데 숫자 출력 -> 중앙값

채점 결과 : 132ms/14660KB
풀이 날짜 : 2021/11/24
*/

public class B2587 {
    static int[] score = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            score[i] = Integer.parseInt(br.readLine());
            sum += score[i];
        }

        Arrays.sort(score);

        bw.write(String.format("%d\n%d", sum / 5, score[2]));
        bw.flush();
        bw.close();
        br.close();
    }
}
