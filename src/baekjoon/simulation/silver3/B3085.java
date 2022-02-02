package baekjoon.simulation.silver3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 3085
문제제목 : 사탕 게임
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
먹을 수 있는 최대 사탕 수를 갱신하는 candyCount() 함수 작성
1. 각 행에 대해 탐색 -> 인접한 두 문자가 서로 다르면 스왑하고 candyCount() 호출, 다시 원래 상태로 복구
    -> 인접한 두 문자가 같으면 candyCount()만 호출
2. 각 열에 대해 똑같이 탐색
3. 갱신된 최대 사탕 수를 출력

채점 결과 : 204ms/14452KB
풀이 날짜 : 2022/02/02
*/

public class B3085 {
    static int n;
    static char[][] candy;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            candy[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (candy[i][j] != candy[i][j+1]) {
                    char temp = candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = temp;
                    candyCount();
                    candy[i][j+1] = candy[i][j];
                    candy[i][j] = temp;
                } else {
                    candyCount();
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (candy[i][j] != candy[i+1][j]) {
                    char temp = candy[i][j];
                    candy[i][j] = candy[i+1][j];
                    candy[i+1][j] = temp;
                    candyCount();
                    candy[i+1][j] = candy[i][j];
                    candy[i][j] = temp;
                } else {
                    candyCount();
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    static void candyCount() {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (candy[i][j] == candy[i][j+1]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 0; i < n - 1; i++) {
                if (candy[i][j] == candy[i+1][j]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }
    }
}
