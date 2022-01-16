package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1913
문제제목 : 달팽이
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 달팽이를 중심부터 그리지 말고, (0, 0)부터 그려준다.
2. 행과 열을 움직이는 포인터 2개와(r, c)
3. 현재 사이클의 위치 포인터(cur)
4. 움직일 수 있는 최대 범위 포인터(max)
5. 배열에 담을 숫자(num)
6. 이것들을 조작해서 배열에 하나씩 담아준다.

채점 결과 : 796ms/68520KB
풀이 날짜 : 2022/01/16
*/

public class B1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int num = n * n;
        int r = 0;
        int c = 0;
        int cur = 0;
        int max = n;
        while (num > 0) {
            c = cur;
            for (int i = r; i < max; i++) {
                map[i][c] = num--;
            }
            r = max - 1;
            for (int i = c + 1; i < max; i++) {
                map[r][i] = num--;
            }
            c = max - 1;
            for (int i = r - 1; i >= cur; i--) {
                map[i][c] = num--;
            }
            r = cur;
            for (int i = c - 1; i > cur; i--) {
                map[r][i] = num--;
            }
            cur++;
            max--;
            r = cur;
        }

        int tR = 0, tC = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
                if (map[i][j] == t) {
                    tR = i + 1;
                    tC = j + 1;
                }
            }
            bw.newLine();
        }
        bw.write(tR + " " + tC);

        bw.flush();
        bw.close();
        br.close();
    }
}
