package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 13300
문제제목 : 방 배정
난이도 : 브론즈 2
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 수학

알고리즘 설명
1. 학년, 성별별 학생 수를 받아놓고
2. 천장함수 사용하여 필요한 방의 개수 count

채점 결과 : 148ms/14612KB
풀이 날짜 : 2021/11/27
*/

public class B13300 {
    static int n, k;
    static int[] girls, boys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        girls = new int[7];
        boys = new int[7];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (sex == 0) {
                girls[grade]++;
            } else {
                boys[grade]++;
            }
        }

        int count = 0;

        for (int i = 1; i <= 6; i++) {
            count += Math.ceil((double) girls[i] / k);
            count += Math.ceil((double) boys[i] / k);
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
