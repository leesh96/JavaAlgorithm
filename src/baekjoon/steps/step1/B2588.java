package baekjoon.steps.step1;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2588
 * 문제제목 : 곱셈
 * 난이도 : 브론즈 4
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 수학, 사칙연산
 *
 * 채점 결과 : 156ms/14584KB
 * 풀이 날짜 : 2021/08/05
**/

public class B2588 {
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int temp = a * (b % 10);
            result += temp * (int)(Math.pow(10, i));
            b /= 10;
            bw.write(temp + "\n");
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
