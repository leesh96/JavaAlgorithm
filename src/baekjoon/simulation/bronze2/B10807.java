package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10807
문제제목 : 개수 세기
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. 정렬
2. 이분탐색으로 bound 탐색

채점 결과 : 128ms/14396KB
풀이 날짜 : 2021/11/25
*/

public class B10807 {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int v = Integer.parseInt(br.readLine());

        bw.write((upperBound(v) - lowerBound(v)) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int upperBound(int value) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    static int lowerBound(int value) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
