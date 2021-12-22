package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2755
문제제목 : 이번학기 평점은 몇점?
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 사칙연산

알고리즘 설명
1. 그냥 단순 구현, double형 사용, format String 사용

채점 결과 : 132ms/14544KB
풀이 날짜 : 2021/12/22
*/

public class B2755 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        double score = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            int credit = Integer.parseInt(st.nextToken());
            total += credit;
            String grade = st.nextToken();

            if (grade.equals("A+")) {
                score += credit * 4.3;
            } else if (grade.equals("A0")) {
                score += credit * 4.0;
            } else if (grade.equals("A-")) {
                score += credit * 3.7;
            } else if (grade.equals("B+")) {
                score += credit * 3.3;
            } else if (grade.equals("B0")) {
                score += credit * 3.0;
            } else if (grade.equals("B-")) {
                score += credit * 2.7;
            } else if (grade.equals("C+")) {
                score += credit * 2.3;
            } else if (grade.equals("C0")) {
                score += credit * 2.0;
            } else if (grade.equals("C-")) {
                score += credit * 1.7;
            } else if (grade.equals("D+")) {
                score += credit * 1.3;
            } else if (grade.equals("D0")) {
                score += credit * 1.0;
            } else if (grade.equals("D-")) {
                score += credit * 0.7;
            }
        }

        bw.write(String.format("%.2f", score / total));
        bw.flush();
        bw.close();
        br.close();
    }
}
