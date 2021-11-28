package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2711
문제제목 : 오타맨 고창영
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. StringBuilder replace 함수 사용

채점 결과 : 120ms/14188KB
풀이 날짜 : 2021/11/28
*/

public class B2711 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            StringBuilder str = new StringBuilder(st.nextToken());
            str.replace(idx - 1, idx, "");
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
