package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 3985
문제제목 : 롤 케이크
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 케이크 조각이 사람에게 배정되었는지 표시하는 부울 배열 선언
2. 실제 max와 예측 max를 따로 관리

채점 결과 : 140ms/14712KB
풀이 날짜 : 2021/12/13
*/

public class B3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] cake = new boolean[l+1];

        int predict = 0;
        int predictMax = Integer.MIN_VALUE;
        int real = 0;
        int realMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k - p + 1 > predictMax) {
                predict = i + 1;
                predictMax = k - p + 1;
            }

            for (int j = p; j <= k; j++) {
                if (!cake[j]) {
                    sum++;
                    cake[j] = true;
                }
            }

            if (sum > realMax) {
                real = i + 1;
                realMax = sum;
            }
        }

        bw.write(String.format("%d\n%d", predict, real));
        bw.flush();
        bw.close();
        br.close();
    }
}
