package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2743
문제제목 : 단어 길이 재기
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 길이 length() 함수

채점 결과 : 124ms/14224KB
풀이 날짜 : 2021/11/21
*/

public class B2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.readLine().length() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
