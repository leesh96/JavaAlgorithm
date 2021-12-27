package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1292
문제제목 : 쉽게 푸는 문제
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 길이 1000의 배열에 숫자를 규칙대로 넣고
2. 구간 합을 구함

채점 결과 : 128ms/14292KB
풀이 날짜 : 2021/12/27
*/

public class B1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[1002];
        int idx = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (idx > 1000) break;
                arr[idx++] = i;
            }
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
