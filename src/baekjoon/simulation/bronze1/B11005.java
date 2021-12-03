package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11005
문제제목 : 진법 변환 2
난이도 : 브론즈 1
제한사항 : 0.5초/256MB
알고리즘 분류 : 구현, 수학

알고리즘 설명
1. Integer.toString(int n, int radix) 사용

채점 결과 : 132ms/14320KB
풀이 날짜 : 2021/12/03
*/

public class B11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(n, b).toUpperCase(Locale.ROOT));
        bw.flush();
        bw.close();
        br.close();
    }
}
