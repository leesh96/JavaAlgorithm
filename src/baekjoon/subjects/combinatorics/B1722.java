package baekjoon.subjects.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1722
 * 문제제목 : 순열의 순서
 * 난이도 : 실버 1
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 2초/128MB
 *
 * 알고리즘 설명
 * 1. 순열의 자릿수에 올 수 있는 숫자가 n개 라면 각 숫자마다 n-1! 만큼의 경우의 수 존재
 * 2. k번째 순열을 구하기 위해 순열 첫 자리부터 경우의 수를 빼가면서 숫자를 찾음
 * 3. 앞에서 숫자 사용했다면 마킹하고 계산하지 않음
 * 4. 순열이 몇 번째인지 찾는 것은 역으로 구하면 된다.
 *
 * 채점 결과 : 80ms/11560KB
 * 풀이 날짜 : 2021/07/13
**/

public class B1722 {
    static int n;
    static long[] fact = new long[21];
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        fact[0] = 1;
        getFact(n);

        st = new StringTokenizer(br.readLine());
        int order = Integer.parseInt(st.nextToken());

        if (order == 1) {
            long k = Long.parseLong(st.nextToken());
            used = new boolean[n+1];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (used[j]) continue;

                    if (fact[n - i - 1] < k) {
                        k -= fact[n - i - 1];
                    } else {
                        bw.write(j + " ");
                        used[j] = true;
                        break;
                    }
                }
            }
        } else {
            long count = 1;
            used = new boolean[n+1];
            for (int i = 0; i < n; i ++) {
                int cur = Integer.parseInt(st.nextToken());
                for (int j = 1; j < cur; j++) {
                    if (!used[j]) {
                        count += fact[n - i - 1];
                    }
                }
                used[cur] = true;
            }
            bw.write(count + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void getFact(int n) {
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i;
        }
    }
}
