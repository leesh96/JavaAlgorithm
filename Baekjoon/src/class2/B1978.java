package class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1978
 * 문제제목 : 소수 찾기
 * 난이도 : 실버 4
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
 *
 * 알고리즘 설명
 * 에라토스테네스의 체 구현
 *
 * 채점 결과 : 84ms/11644KB
 * 풀이 날짜 : 2021/07/18
**/

public class B1978 {
    static int n;
    static boolean[] che;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        che = new boolean[1001];
        for (int i = 2; i <= 1000; i++) {
            if (che[i]) continue;
            for (int j = i + i; j <= 1000; j += i) {
                che[j] = true;
            }
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (!che[cur] && cur != 1) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
