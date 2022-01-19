package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2670
문제제목 : 연속부분최대곱
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : DP, 브루트포스 알고리즘

알고리즘 설명
1. 누적곱 개념으로 접근
2. nums[i]와 nums[i-1]*nums[i] 중 더 큰 값으로 nums[i]를 계속 갱신해준다.
3. 최대값도 같이 갱신

채점 결과 : 192ms/18552KB
풀이 날짜 : 2022/01/19
*/

public class B2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        double max = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] * nums[i]);
            max = Math.max(max, nums[i]);
        }

        bw.write(String.format("%.3f", max));
        bw.flush();
        bw.close();
        br.close();
    }
}
