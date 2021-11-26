package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2846
문제제목 : 오르막길
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 현재위치와 앞의 길을 비교해서 앞의 길이 큰 경우(오르막길) 그 차이를 더해줌
2. 아닌경우 다시 0으로 세팅
3. 계속해서 오르막의 크기 갱신

채점 결과 : 132ms/14352KB
풀이 날짜 : 2021-11-26
*/

public class B2846 {
    static int n;
    static int[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        road = new int[n];
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (road[i] < road[i+1]) {
                sum += road[i+1] - road[i];
            } else {
                sum = 0;
            }
            max = Math.max(max, sum);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
