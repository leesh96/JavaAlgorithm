package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1193
문제제목 : 분수찾기
난이도 : 브론즈 1
제한사항 : 0.5초/256MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 대각선은 분자분모의 합 = 2, 3, ... 증가
2. 대각선의 분수 수는 대각선 순서 - 1
3. 대각선을 읽는 방향 : 대각선의 합 수를 2로 나눈 나머지에 따라 다름

채점 결과 : 128ms/14552KB
풀이 날짜 : 2021/11/29
*/

public class B1193 {
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());

        int cross = 1;
        int count = 0;

        while (true) {
            if (x <= count + cross) {
                if (cross % 2 == 1) {
                    bw.write(String.format("%d/%d", cross - (x - count - 1), x - count));
                } else {
                    bw.write(String.format("%d/%d", x - count, cross - (x - count - 1)));
                }
                break;
            } else {
                count += cross;
                cross++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
