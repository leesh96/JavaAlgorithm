package baekjoon.simulation.silver5;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2578
문제제목 : 빙고
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 정수형 5*5 배열에 숫자 입력
2. 부르는 숫자 입력받으면서 0으로 바꾸고 빙고 수 체크(행, 열, 대각선 체크하는 함수로 구현)
3. 빙고 수가 3과 같거나 크면 종료하고 숫자 부른 개수 출력
4. 빙고 수가 3보다 작으면 빙고 수를 다시 0으로 초기화

채점 결과 : 136ms/14448KB
풀이 날짜 : 2021/12/29
*/

public class B2578 {
    static int[][] bingo;
    static HashMap<Integer, Point> numAndPoint;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        bingo = new int[5][5];
        numAndPoint = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                numAndPoint.put(num, new Point(i, j));
            }
        }

        int count = 0;
        int time = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            boolean threeBingo = false;

            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                time++;
                Point p = numAndPoint.get(call);
                bingo[p.r][p.c] = 0;

                count += rowCheck();
                count += colCheck();
                count += rCheck();
                count += lCheck();

                if (count >= 3) {
                    threeBingo = true;
                    break;
                } else {
                    count = 0;
                }
            }

            if (threeBingo) {
                break;
            }
        }

        bw.write(String.format("%d", time));
        bw.flush();
        bw.close();
        br.close();
    }

    static int rowCheck() {
        int ret = 0;

        for (int i = 0; i < 5; i++) {
            boolean flag = true;

            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ret++;
            }
        }

        return ret;
    }

    static int colCheck() {
        int ret = 0;

        for (int i = 0; i < 5; i++) {
            boolean flag = true;

            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ret++;
            }
        }

        return ret;
    }

    static int rCheck() {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                return 0;
            }
        }

        return 1;
    }

    static int lCheck() {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4-i] != 0) {
                return 0;
            }
        }

        return 1;
    }
}
