package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11054
문제제목 : 가장 긴 바이토닉 부분 수열
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. 바이토닉 부분 수열 : 증가하다가 감소하는 모양의 부분 수열 (증가만 해도 되고, 감소만 해도 된다)
2. 정방향 LIS, 역방향 LIS를 한 후 두 값을 더해주면 바이토닉 부분 수열
3. 이 때, 그 자리의 원소가 두 번 들어가기 때문에 -1
4. 가장 긴 길이의 바이토닉 부분 수열 출력

채점 결과 : 204ms/18676KB
풀이 날짜 : 2021/11/10
*/

public class B11054 {
    static int n;
    static int[] arr;
    static int[] left, right;

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

        left = new int[n];
        right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            right[i] = 1;

            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            left[i] += right[i] - 1;
            answer = Math.max(answer, left[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
