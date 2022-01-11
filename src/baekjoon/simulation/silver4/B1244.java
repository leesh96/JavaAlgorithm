package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1244
문제제목 : 스위치 켜고 끄기
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 인덱스 조작으로 스위치 변경
2. 1과 XOR 비트 연산으로 켜짐, 꺼짐 상태 변경

채점 결과 : 164ms/15812KB
풀이 날짜 : 2021/11/20
*/

public class B1244 {
    static int n, m;
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        switches = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int idx = num; idx <= n; idx += num) {
                    switches[idx] ^= 1;
                }
            } else {
                int left = num;
                int right = num;

                while (true) {
                    if (left < 1 || right > n) {
                        break;
                    }
                    if (switches[left] != switches[right]) {
                        break;
                    }

                    left--;
                    right++;
                }
                left++;
                right--;

                while (left <= right) {
                    switches[left] ^= 1;
                    left++;
                }
            }
        }

        for (int idx = 1; idx <= n; idx++) {
            bw.write(switches[idx] + " ");
            if (idx % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
