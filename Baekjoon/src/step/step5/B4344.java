package step.step5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 4344
 * 문제제목 : 평균은 넘겠지
 * 난이도 : 브론즈 1
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 수학, 사칙연산
 *
 * 채점 결과 : 188ms/15588KB
 * 풀이 날짜 : 2021/08/07
**/

public class B4344 {
    static int c, n;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        c = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < c; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            score = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                sum += score[i];
            }
            double avg = sum / n;
            double count = 0;
            for (int s : score) {
                if (s > avg) {
                    count++;
                }
            }
            bw.write(String.format("%.3f", count * 100 / n) + "%\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
