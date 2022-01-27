package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1205
문제제목 : 등수 구하기
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. n이 0이면 항상 1
2. n이 p와 같거나 현재 점수의 가장 낮은 점수 보다 새로운 점수가 작거나 같으면 랭크에 들 수 없음 -> -1
3. 위의 두 경우 전부 아니면 새로운 점수보다 큰 점수 count

채점 결과 : 136ms/14216KB
풀이 날짜 : 2022/01/27
*/

public class B1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            bw.write("1");
        } else {
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (n == p && score <= arr[n - 1]) {
                bw.write("-1");
            } else {
                int rank = 1;
                for (int s : arr) {
                    if (score < s) {
                        rank++;
                    } else {
                        break;
                    }
                }
                bw.write(String.valueOf(rank));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
