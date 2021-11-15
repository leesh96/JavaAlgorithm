package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10810
문제제목 : 공 넣기
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 바구니의 정보를 저장하는 배열 선언
2. 입력에 주어진 정보대로 공 넣기
3. 바구니 정보 출력

채점 결과 : 148ms/15956KB
풀이 날짜 : 2021/11/15
*/

public class B10810 {
    static int n, m;
    static int[] basket;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        basket = new int[n+1];
        for (int c = 0; c < m; c++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (; i <= j; i++) {
                basket[i] = k;
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(basket[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
