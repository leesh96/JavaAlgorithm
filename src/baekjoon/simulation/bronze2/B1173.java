package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1173
문제제목 : 운동
난이도 : 브론즈 2
제한사항 : 2초/16MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 최소 맥박 + 증가 맥박이 항상 최대 맥박보다 큰 경우 운동을 절대 못하는 경우
2. 그외의 경우 조건에 맞게 반복 수행

채점 결과 : 128ms/14264KB
풀이 날짜 : 2021/11/16
*/

public class B1173 {
    static int n, minM, targetM, t, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        minM = Integer.parseInt(st.nextToken());
        targetM = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int m = minM;
        int time = 0;
        int ext = 0;

        if (minM + t > targetM) {
            bw.write(-1 + "");
        } else {
            while (ext < n) {
                if (m + t <= targetM) {
                    m += t;
                    ext++;
                } else {
                    m -= r;
                    if (m < minM) {
                        m = minM;
                    }
                }

                time++;
            }

            bw.write(time + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
