package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10798
문제제목 : 세로읽기
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 입력 받을 때 세로 열에 해당하는 문자열에 문자 추가
2. 세로 열 순서대로 출력

채점 결과 : 128ms/14288KB
풀이 날짜 : 2021/12/02
*/

public class B10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder[] stringBuilders = new StringBuilder[15];
        for (int i = 0; i < 15; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();

            for (int k = 0; k < input.length(); k++) {
                stringBuilders[k].append(input.charAt(k));
            }
        }

        for (int i = 0; i < 15; i++) {
            bw.write(stringBuilders[i].toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
