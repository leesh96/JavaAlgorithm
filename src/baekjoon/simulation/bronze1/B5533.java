package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 5533
문제제목 : 유니크
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 사칙연산

알고리즘 설명
1. 배열에 점수 기록
2. 완전 탐색으로 점수 계산

채점 결과 : 152ms/14932KB
풀이 날짜 : 2021/12/17
*/

public class B5533 {
    static int n;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        score = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                int cur = score[i][j];
                boolean isDuplicated = false;

                for (int k = 0; k < n; k++) {
                    if (i == k) continue;

                    if (cur == score[k][j]) {
                        isDuplicated = true;
                    }
                }

                if (!isDuplicated) {
                    sum += cur;
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
