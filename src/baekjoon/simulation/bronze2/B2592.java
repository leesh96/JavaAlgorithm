package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2592
문제제목 : 대표값
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 10으로 나눈 몫 카운트
2. 가장 자주 등장하는 값이 최빈값

채점 결과 : 136ms/15772KB
풀이 날짜 : 2021/11/27
*/

public class B2592 {
    static int[] count = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            count[num / 10]++;
        }

        bw.write((sum / 10) + "\n");

        int maxCount = 0;
        int maxNum = 0;
        for (int i = 0; i < 100; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxNum = i * 10;
            }
        }

        bw.write(maxNum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
