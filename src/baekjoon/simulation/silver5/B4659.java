package baekjoon.simulation.silver5;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 4659
문제제목 : 비밀번호 발음하기
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 조건에 맞게 문자열 탐색

채점 결과 : 132ms/14488KB
풀이 날짜 : 2022/01/10
*/

public class B4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals("end")) {
                break;
            }

            char last = '0';
            int moCount = 0;
            int jaCount = 0;
            int sameCount = 1;
            boolean containsMo = false;
            boolean flag = true;
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);

                if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                    if (!containsMo) {
                        containsMo = true;
                    }
                    jaCount = 0;
                    moCount++;
                } else {
                    moCount = 0;
                    jaCount++;
                }

                if (last == cur) {
                    sameCount++;
                } else {
                    sameCount = 1;
                }

                if (moCount >= 3 || jaCount >= 3) {
                    flag = false;
                    break;
                } else if (sameCount >= 2 && !((last == 'e' && cur == 'e') || (last == 'o' && cur == 'o'))) {
                    flag = false;
                    break;
                }

                last = cur;
            }

            if (flag && containsMo) {
                bw.write(String.format("<%s> is acceptable.\n", input));
            } else {
                bw.write(String.format("<%s> is not acceptable.\n", input));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
