package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10988
문제제목 : 팰린드롬인지 확인하기
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 처음과 끝에서 시작하는 투 포인터 사용하여 비교

채점 결과 : 136ms/14248KB
풀이 날짜 : 2021/12/02
*/

public class B10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int start = 0;
        int end = input.length() - 1;
        boolean flag = true;
        while (start <= end) {
            if (input.charAt(start) != input.charAt(end)) {
                flag = false;
                break;
            }

            start++;
            end--;
        }

        if (flag) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
