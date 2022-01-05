package baekjoon.simulation.silver5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1059
문제제목 : 좋은 구간
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 브루트포스 알고리즘

알고리즘 설명
입력 숫자 배열에서
1. n보다 작은 것 중에 최대값을 찾고
2. n보다 큰 것 중에 최소값을 찾는다.
3. n이 배열에 있으면 구간은 만들 수 없음.

채점 결과 : 136ms/14363KB
풀이 날짜 : 2022/01/05
*/

public class B1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int l = Integer.parseInt(br.readLine());

        int[] nums = new int[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        int left = 0;
        int right = nums[l-1] + 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n) {
                right = Math.min(right, nums[i]);
            } else if (nums[i] < n) {
                left = Math.max(left, nums[i]);
            } else {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("0");
        } else {
            int start = n - left - 1;
            int end = right - n - 1;
            int answer = start + end + (start * end);
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
