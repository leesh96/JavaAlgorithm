package baekjoon.simulation.silver3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1051
문제제목 : 숫자 정사각형
난이도 : 실버 3
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. 최대로 만들 수 있는 정사각형 변의 길이는 n과 m 중의 최솟값
2. 왼쪽 시작점을 기준으로 비교
3. 최대 길이 까지 보면서
4. 4 꼭지점 확인

채점 결과 : 132ms/14344KB
풀이 날짜 : 2022/02/09
*/

public class B1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int maxSquare = Math.min(n, m);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < maxSquare; k++) {
                    if (i + k < n && j + k < m) {
                        if (arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k]) {
                            answer = Math.max(answer, (int) Math.pow(k+1, 2));
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
