package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 9093
문제제목 : 단어 뒤집기
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 공백으로 분리
2. StringBuilder의 reverse() 메소드 사용해서 각 단어 뒤집기

채점 결과 : 520ms/47772KB
풀이 날짜 : 2021/12/16
*/

public class B9093 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                bw.write(new StringBuilder(st.nextToken()).reverse() + " ");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
