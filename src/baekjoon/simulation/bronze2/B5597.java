package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 5597
문제제목 : 과제 안 내신 분..?
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 과제 여부를 저장하는 불리언 배열로 구현

채점 결과 : 144ms/15816Kb
풀이 날짜 : 2021/11/23
*/

public class B5597 {
    static final int SIZE = 30;

    static boolean[] student = new boolean[SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals("")) {
                break;
            }

            student[Integer.parseInt(input)] = true;
        }

        for (int i = 1; i <= SIZE; i++) {
            if (!student[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
