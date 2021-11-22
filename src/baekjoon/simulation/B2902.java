package baekjoon.simulation;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2902
문제제목 : KMP는 왜 KMP일까?
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열을 - 구분자로 분리
2. 각 분리된 문자열의 첫글자를 붙여서 출력

채점 결과 : 124ms/14352KB
풀이 날짜 : 2021/11/22
*/

public class B2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split("-");
        for (String s : input) {
            bw.write(s.charAt(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
