package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 9047
문제제목 : 6174
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 문자열 다루기
2. 조건대로 풀기

채점 결과 : 156ms/16188KB
풀이 날짜 : 2021/11/19
*/

public class B9047 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int count = 0;
            String input = br.readLine();

            while (true) {
                if (input.equals("6174")) {
                    bw.write(count + "\n");
                    break;
                }

                char[] arr = input.toCharArray();
                Arrays.sort(arr);

                StringBuilder min = new StringBuilder();
                StringBuilder max = new StringBuilder();

                for (int i = 0, j = 3; i < 4 && j >= 0; i++, j--) {
                    min.append(arr[i]);
                    max.append(arr[j]);
                }

                int temp = Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
                input = String.valueOf(temp);

                if (input.length() == 1) {
                    input = "000" + input;
                } else if (input.length() == 2) {
                    input = "00" + input;
                } else if (input.length() == 3) {
                    input = "0" + input;
                }

                count++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
