package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.HashSet;

/*
플랫폼 : 백준
문제번호 : 10448
문제제목 : 유레카 이론
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 세 삼각수로 만들 수 있는 숫자를 집합에 저장
2. 각 테스트케이스에서 주어지는 숫자가 집합에 포함되어있으면 1, 없으면 0

채점 결과 : 188ms/17432KB
풀이 날짜 : 2021/11/25
*/

public class B10448 {
    static int t;
    static int[] triNums;
    static HashSet<Integer> set = new HashSet<>();

    static final int MAX = 45;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        triNums = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            triNums[i] = (i * (i + 1)) / 2;
        }

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                for (int k = 1; k <= MAX; k++) {
                    set.add(triNums[i] + triNums[j] + triNums[k]);
                }
            }
        }

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int num = Integer.parseInt(br.readLine());

            if (set.contains(num)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
