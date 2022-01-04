package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1712
문제제목 : 손익분기점
난이도 : 브론즈 4
제한사항 : 0.35초/128MB
알고리즘 분류 : 수학, 사칙연산

알고리즘 설명
1. 손익분기점 계산

채점 결과 : 128ms/14240KB
풀이 날짜 : 2022/01/04
*/

public class B1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (c <= b) {
            bw.write("-1");
        } else {
            bw.write(((a / (c - b)) + 1) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
