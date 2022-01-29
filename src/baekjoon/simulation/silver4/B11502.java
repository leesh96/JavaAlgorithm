package baekjoon.simulation.silver4;

import java.io.*;
import java.util.ArrayList;

/*
플랫폼 : 백준
문제번호 : 11502
문제제목 : 세 개의 소수 문제
난이도 : 실버 4
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 브루트포스 알고리즘, 정수론, 소수 판정, 에라토스테네스의 체

알고리즘 설명
1. 에라토스테네스의 체로 소수 구해놓고
2. 3 소수의 중복조합 -> 합계 계산

채점 결과 : 232ms/15924KB
풀이 날짜 : 2022/01/29
*/

public class B11502 {
    static ArrayList<Integer> primes;
    static int k;
    static boolean isAvail;
    static int[] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1000];
        for (int i = 2; i < (int) Math.sqrt(1000) + 1; i++) {
            if (!prime[i]) {
                for (int j = i+i; j < 1000; j += i) {
                    prime[j] = true;
                }
            }
        }

        primes = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (!prime[i]) primes.add(i);
        }

        while (t-- > 0) {
            k = Integer.parseInt(br.readLine());
            isAvail = false;
            comb = new int[3];
            dfs(comb, 0, 0);

            if (isAvail) {
                for (int n : comb) bw.write(n + " ");
                bw.newLine();
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] comb, int cur, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int n : comb) sum += n;
            if (sum == k) isAvail = true;
            else isAvail = false;
            return;
        }

        for (int i = cur; i < primes.size(); i++) {
            comb[depth] = primes.get(i);
            dfs(comb, i, depth + 1);
            if (isAvail) {
                return;
            }
        }
    }
}
