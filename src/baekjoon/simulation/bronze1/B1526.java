package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1526
문제제목 : 가장 큰 금민수
난이도 : 브론즈 1
제한사항 : 2초/256MB
알고리즘 분류 : 구현, 수학

알고리즘 설명
1. 재귀로 탐색
2. 종료조건 : n 보다 커질 경우
3. 각 노드는 * 10을 하고 + 4 또는 + 7을 해서 다음 탐색 진행
4. 각 노드에서 결과값이 항상 최대값이도록 갱신

채점 결과 : 132ms/14472KB
풀이 날짜 : 2021/12/11
*/

public class B1526 {
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(0);

        bw.write(String.format("%d", result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        if (cur > n) {
            return;
        }

        result = Math.max(result, cur);

        dfs(cur * 10 + 4);
        dfs(cur * 10 + 7);
    }
}
