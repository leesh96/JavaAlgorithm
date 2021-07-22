package class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2839
 * 문제제목 : 설탕 배달
 * 난이도 : 브론즈1
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 그리디, DP
 *
 * 알고리즘 설명
 * 1. 5로 나누어 떨어지면 5로 나눈 몫이 가방 수, 종료
 * 2. 5로 나누어 떨어지지 않으면 3씩 빼면서 가방수 +1
 * 3. 종료 되지 않고 끝났다면 -1 출력
 * DP로 풀 수 있는 문제
 *
 * 채점 결과 : 84ms/11600KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2839 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if (dp[i - 3] != 0 && dp[i - 5] != 0){
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                }
            }
        }

        if (dp[n] != 0) {
            bw.write(dp[n] + "\n");
        } else {
            bw.write("-1\n");
        }

//        int result = 0;
//        boolean isAvail = false;
//        while (n >= 0) {
//            if (n % 5 == 0) {
//                result += n / 5;
//                isAvail = true;
//                break;
//            }
//            n -= 3;
//            result++;
//        }
//        if (isAvail) {
//            bw.write(result + "\n");
//        } else {
//            bw.write("-1\n");
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
