package baekjoon.steps.step1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10430
 * 문제제목 : 나머지
 * 난이도 : 브론즈 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 수학, 구현, 사칙연산
 *
 * 알고리즘 설명
 * 나머지 연산 증명
 *
 * 채점 결과 : 152ms/14532KB
 * 풀이 날짜 : 2021/08/05
**/

public class B10430 {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bw.write(String.format("%d\n", (a+b)%c));
        bw.write(String.format("%d\n", (a%c + b%c) % c));
        bw.write(String.format("%d\n", (a*b)%c));
        bw.write(String.format("%d\n", (a%c * b%c) % c));
        bw.flush();
        bw.close();
        br.close();
    }
}
