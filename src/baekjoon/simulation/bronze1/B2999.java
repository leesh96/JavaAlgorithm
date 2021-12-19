package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2999
문제제목 : 비밀 일기장
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 1부터 제곱근 까지 비교하면서 r이 가장 큰 r * c = n 조합을 찾는다.
2. 열 우선으로 입력 문자열을 적고
3. 행 우선으로 출력

채점 결과 : 124ms/14296KB
풀이 날짜 : 2021/12/19
*/

public class B2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int n = input.length();
        int r = 0;
        int c = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                r = i;
                c = n / i;
            }
        }

        char[][] matrix = new char[r][c];
        int idx = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                matrix[j][i] = input.charAt(idx++);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(matrix[i][j] + "");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
