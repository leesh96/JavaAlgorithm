package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
플랫폼 : 백준
문제번호 : 2750
문제제목 : 수 정렬하기
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 정렬

알고리즘 설명
1. 우선순위 큐 사용 (힙 정렬)
2. 배열 정렬 사용

채점 결과 : 268ms/17640KB(우선순위 큐), 252ms/18144KB(배열 정렬)
풀이 날짜 : 2021/11/29
*/

public class B2750 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        /*PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty()) {
            bw.write(String.format("%d\n", pq.poll()));
        }*/

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        for (int k : nums) {
            bw.write(String.format("%d\n", k));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
