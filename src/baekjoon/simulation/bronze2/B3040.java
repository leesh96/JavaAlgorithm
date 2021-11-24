package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 3040
문제제목 : 백설 공주와 일곱 난쟁이
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. 9명의 합을 미리 구하고
2. 2명을 뽑아 빼서 100이되면 종료

채점 결과 : 152ms/14616KB
풀이 날짜 : 2021/11/24
*/

public class B3040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] height = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - height[i] - height[j] == 100) {
                    height[i] = -1;
                    height[j] = -1;
                    break;
                }
            }
        }

        for (int h : height) {
            if (h != -1) {
                bw.write(h + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
