package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 5598
문제제목 : 카이사르 암호
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 아스키코드에서 -3
2. 'A'(65)보다 작아지면 +26

채점 결과 : 124ms/14160KB
풀이 날짜 : 2021/11/27
*/

public class B5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        for (char cur : input) {
            char temp = (char)(cur - 3);

            if (temp < 'A') {
                temp = (char)(temp + 26);
            }

            bw.write(temp);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
