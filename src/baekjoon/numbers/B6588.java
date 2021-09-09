package baekjoon.numbers;

import java.io.*;
import java.util.ArrayList;

/**
 * 플랫폼 : 백준
 * 문제번호 : 6588
 * 문제제목 : 골드바흐의 추측
 * 난이도 : 실버 1
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 수학, 정수론, 소수판정, 에라토스테네스의 체
 *
 * 알고리즘 설명
 * 1. 에라토스테네스의 체를 사용하여 소수 구하기
 * 2. 6이상의 짝수는 2로는 다른 소수의 합으로 나타낼 수 없기 때문에
 * 3. 소수 3부터 검증
 *
 * 채점 결과 : 1356ms/98220KB
 * 풀이 날짜 : 2021/08/15
**/

public class B6588 {
    static final int MAX = 1000001;
    static int n;
    static boolean[] che;
    static ArrayList<Integer> prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        che = new boolean[MAX];
        for (int i = 2; i < Math.sqrt(MAX) + 1; i++) {
            if (che[i]) {
                continue;
            }
            for (int j = i + i; j < MAX; j += i) {
                if (!che[j]) {
                    che[j] = true;
                }
            }
        }
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) break;

            for (int i = 3; i < input; i++) {
                if (!che[i]) {
                    if (!che[input - i]) {
                        bw.write(String.format("%d = %d + %d\n", input, i, input - i));
                        break;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
