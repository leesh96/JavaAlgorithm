package baekjoon.simulation;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 2309
문제제목 : 일곱 난쟁이
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 브루트포스

알고리즘 설명
1. 7난쟁이의 키의 합은 항상 100
2. 합이 100이 되지 않는 입력은 주어지지 않음
3. 키를 정렬해놓고 두 개씩 골라서 빼고 결과가 100이 되면 종료

채점 결과 : 140ms/15856KB
풀이 날짜 : 2021/11/21
*/

public class B2309 {
    static int[] heights = new int[9];
    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);

        boolean flag = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - heights[i] - heights[j] == MAX) {
                    heights[i] = -1;
                    heights[j] = -1;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        for (int h : heights) {
            if (h != -1) {
                bw.write(h + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
