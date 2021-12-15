package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10769
문제제목 : 행복한지 슬픈지
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열, 파싱

알고리즘 설명
1. 문자열의 문자 인덱스 증가키면서 startWith() 메소드 사용

채점 결과 : 116ms/14128KB
풀이 날짜 : 2021/12/15
*/

public class B10769 {
    static final String HAPPY_STR = ":-)";
    static final String SAD_STR = ":-(";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int happyCnt = 0;
        int sadCnt = 0;
        for (int i = 0; i < input.length() - 3; i++) {
            if (input.startsWith(HAPPY_STR, i)) {
                happyCnt++;
            } else if (input.startsWith(SAD_STR, i)) {
                sadCnt++;
            }
        }

        if (happyCnt == 0 && sadCnt == 0) {
            bw.write("none");
        } else if (happyCnt > sadCnt) {
            bw.write("happy");
        } else if (happyCnt < sadCnt) {
            bw.write("sad");
        } else if (happyCnt == sadCnt) {
            bw.write("unsure");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
