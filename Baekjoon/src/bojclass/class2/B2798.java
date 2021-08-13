package bojclass.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2798
 * 문제제목 : 블랙잭
 * 난이도 : 브론즈 2
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 완전탐색
 *
 * 알고리즘 설명
 * 1. 재귀로 숫자 조합 구현
 * 2. 재귀 종료 : 현재까지 합이 m보다 큰 경우, 뽑은 카드 수가 3이 되었을 때 -> 이때는 최댓값 갱신 후 리턴
 *
 * 채점 결과 : 104ms/11828KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2798 {
    static int n, m, result;
    static int[] num;
    static boolean[] visit;
    static final int MAX = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        visit = new boolean[n];
        result = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int cur, int sum) {
        if (sum > m) {
            return;
        }
        if (cur == MAX) {
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recur(cur + 1, sum + num[i]);
                visit[i] = false;
            }
        }
    }
}
