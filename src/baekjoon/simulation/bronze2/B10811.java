package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10811
문제제목 : 바구니 뒤집기
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 스왑과 포인터로 바구니 뒤집기

채점 결과 : 156ms/15920KB
풀이 날짜 : 2021/11/15
*/

public class B10811 {
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
        for (int i = 1; i <= n; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while (start <= end) {
                int temp = basket[end];
                basket[end] = basket[start];
                basket[start] = temp;
                start++;
                end--;
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
