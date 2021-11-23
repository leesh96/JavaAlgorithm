package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1100
문제제목 : 하얀 칸
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 입력을 받으면서 F칸이고, 행 인덱스 + 열 인덱스의 2로 나눈 나머지가 0이면 count++

채점 결과 : 128ms/14240KB
풀이 날짜 : 2021/11/22
*/

public class B1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String row = br.readLine();

            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) == 'F' && (i + j) % 2 == 0) {
                    count++;
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
