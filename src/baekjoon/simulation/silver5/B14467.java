package baekjoon.simulation.silver5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14467
문제제목 : 소가 길을 건너간 이유 1
난이도 : 실버 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현

알고리즘 설명
1. 소의 길 위치를 저장하는 정수 배열 선언
2. 초기에 -1로 채워놓기 -> 초기값을 지정해야 하는 것 때문에 비트마스킹 기법으로 풀지 못했음
3. 소의 관찰 상태를 입력받는데, 해당 소가 초기값 상태라면 소가 길을 건너간 횟수에 추가하지 않음
4. 소가 초기값 상태가 아닌데 길이 바뀌었다면 건너간 횟수에 추가함

채점 결과 : 128ms/14292KB
풀이 날짜 : 2022/01/08
*/

public class B14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] cows = new int[11];
        Arrays.fill(cows, -1);
        int answer = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());

            if (cows[cow] == -1) {
                cows[cow] = road;
            } else {
                if (cows[cow] != road) {
                    answer++;
                }
                cows[cow] = road;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
