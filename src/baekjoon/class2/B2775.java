package baekjoon.class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2775
 * 문제제목 : 부녀회장이 될테야
 * 난이도 : 브론즈 2
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 수학, 누적합
 *
 * 알고리즘 설명
 * 0층부터 올라가면서 해당호 까지의 누적합 계산하고 각층 각호의 주민수 갱신
 *
 * 채점 결과 : 80ms/11412KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2775 {
    static int t, k, n;
    static int[] pSum, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            num = new int[n+1];
            pSum = new int[n+1];
            for (int j = 1; j <= n; j++) {
                num[j] = j;
            }
            for (int j = 0; j < k; j++) {
                for (int k = 1; k <= n; k++) {
                    pSum[k] = pSum[k-1] + num[k];
                    num[k] = pSum[k];
                }
            }
            bw.write(pSum[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
