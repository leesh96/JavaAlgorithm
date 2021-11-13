package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2979
문제제목 : 트럭 주차
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 트럭 입출차 시간에 +1, -1씩 해주고 누적합
2. 최종 트럭 출차 시간까지 돌면서 트럭 수 확인
3. 트럭수 * 요금 누적

채점 결과 : 136ms/14224KB
풀이 날짜 : 2021/11/13
*/

public class B2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] time = new int[101];

        int end = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int depart = Integer.parseInt(st.nextToken());
            time[arrive]++;
            time[depart]--;
            end = Math.max(end, depart);
        }

        int answer = 0;

        for (int i = 1; i <= end; i++) {
            time[i] += time[i-1];
            if (time[i] == 1) {
                answer += a * time[i];
            } else if (time[i] == 2) {
                answer += b * time[i];
            } else if (time[i] == 3) {
                answer += c * time[i];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
