package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2303
문제제목 : 숫자 게임
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 5개의 카드 중에 3개를 뽑아 만드는 조합을 만들고(합계를 바로 구해버림), 3개를 뽑은 경우 일의 자리수를 최대로 계속 갱신
2. 모든 사람에 대해 반복
3. 사람들의 일의 자리수가 제일 큰 사람 추출

채점 결과 : 148ms/14944KB
풀이 날짜 : 2022/01/08
*/

public class B2303 {
    static int[] max;
    static int[][] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        cards = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = new int[n];
        for (int i = 0; i < n; i++) {
            comb(i, 0, 0, 0);
        }

        int maxIdx = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max[i] >= maxValue) {
                maxIdx = i;
                maxValue = max[i];
            }
        }

        bw.write((maxIdx + 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void comb(int idx, int sum, int cur, int depth) {
        if (depth == 3) {
            int temp = sum % 10;
            max[idx] = Math.max(max[idx], temp);
            return;
        }

        for (int i = cur; i < 5; i++) {
            comb(idx, sum + cards[idx][i], i + 1, depth + 1);
        }
    }
}
