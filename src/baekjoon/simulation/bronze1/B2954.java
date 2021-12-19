package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2954
문제제목 : 창영이의 일기장
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 문자 하나씩 탐색
2. 모음 만나면 인덱스 +3, 이외에는 +1

채점 결과 : 124ms/14172KB
풀이 날짜 : 2021/12/19
*/

public class B2954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        for (int i = 0; i < input.length(); ) {
            char cur = input.charAt(i);

            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                i += 3;
            } else {
                i++;
            }

            bw.write(cur + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
