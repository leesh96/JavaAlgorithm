package baekjoon.simulation.silver3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2491
문제제목 : 수열
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 구현, DP

알고리즘 설명
1. 연속하는 수열 검사
2. 같거나 큰 연속 부분 수열, 작거나 같은 연속 부분 수열의 두 길이를 계속 갱신

채점 결과 : 264ms/22920KB
풀이 날짜 : 2022/02/10
*/

public class B2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        int inc = 1;
        for (int i = 0; i < n - 1; i++) {
            if (num[i] <= num[i+1]) {
                inc++;
            } else {
                inc = 1;
            }
            answer = Math.max(answer, inc);
        }
        int dec = 1;
        for (int i = 0; i < n - 1; i++) {
            if (num[i] >= num[i+1]) {
                dec++;
            } else {
                dec = 1;
            }
            answer = Math.max(answer, dec);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
