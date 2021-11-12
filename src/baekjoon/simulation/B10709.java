package baekjoon.simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10709
문제제목 : 기상캐스터
난이도 : 실버 5
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 초기 배열 -1로 초기화
2. 입력 받으면서 구름을 만나면 끝까지 +1씩 하면서 증가
3. 다시 구름이 나오면 해당 지점부터 다시 증가하면서 채움

채점 결과 : 208ms/17608KB
풀이 날짜 : 2021/11/12
*/

public class B10709 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.fill(map[i], -1);
            for (int j = 0; j < m; j++) {
                char cur = input[j];
                if (cur == 'c') {
                    int time = 0;
                    for (int k = j; k < m; k++) {
                        map[i][k] = time;
                        time++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
