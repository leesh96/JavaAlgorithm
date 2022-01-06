package baekjoon.simulation.silver5;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1769
문제제목 : 3의 배수
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열, 재귀

알고리즘 설명
1. 입력받은 문자열의 각 자릿수를 더함 (long형 범위 이내임)
2. count를 세고, 문자열에 결과를 대입

채점 결과 : 268ms/20368KB
풀이 날짜 : 2022/01/06
*/

public class B1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String number = br.readLine();

        int count = 0;
        while (true) {
            if (number.length() == 1) {
                break;
            }

            long sum = 0;
            for (int i = 0; i < number.length(); i++) {
                sum += number.charAt(i) - '0';
            }
            count++;
            number = String.valueOf(sum);
        }

        bw.write(count + "\n");
        if (Integer.parseInt(number) % 3 == 0) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
