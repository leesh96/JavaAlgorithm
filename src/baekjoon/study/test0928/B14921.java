package baekjoon.study.test0928;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14921
문제제목 : 용액 합성하기
난이도 : 골드 5
제한사항 : 1초/512MB
알고리즘 분류 : 투 포인터

알고리즘 설명
1. 양 끝점으로 투 포인터 탐색
2. 현재 두 포인터가 가르키는 용액의 합의 절대값이 더 작은것으로 갱신
3. 합이 0보다 크면 우측 포인터 감소, 합이 0보다 작으면 왼쪽 포인터 증가

채점 결과 : 396ms/25524KB
풀이 날짜 : 2021/10/04
*/

public class B14921 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n - 1;
        long answer = Long.MAX_VALUE;
        while (start < end) {
            long sum = arr[start] + arr[end];
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
