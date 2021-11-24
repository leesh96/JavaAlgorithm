package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 6359
문제제목 : 만취한 상범
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 정수론

알고리즘 설명
1. 0:닫힘, 1:열림의 정수 배열을 1과의 xor 연산으로 배수 인덱스만 탐색하면서 조작
2. 정수 배열의 합을 구한다.

채점 결과 : 144ms/14452KB
풀이 날짜 : 2021/11/24
*/

public class B6359 {
    static int[] room;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            room = new int[n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    room[j] ^= 1;
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += room[i];
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
