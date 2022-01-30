package baekjoon.subjects.trie;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 20166
 * 문제제목 : 문자열 지옥에 빠진 호석
 * 난이도 : 골드 5
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 문자열, 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 해시를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. 깊이 우선 탐색 (MAX_DEPTH = 5)으로 가능한 문자열을 모두 찾아서 맵에 카운트 저장
 * 2. 찾고자 하는 문자열의 경우의 수 출력
 *
 * 채점 결과 : 492ms/57396KB
 * 풀이 날짜 : 2021/08/03
**/

public class B20166 {
    static final int MAX_DEPTH = 5;
    static int n, m, k;
    static char[][] world;
    static HashMap<String, Integer> map;

    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        world = new char[n][];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            world[i] = br.readLine().trim().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs("" + world[i][j], 1, i, j);
            }
        }
        for (int i = 0; i < k; i++) {
            String target = br.readLine();
            if (map.containsKey(target)) {
                bw.write(map.get(target) + "\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(String s, int depth, int r, int c) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (depth == MAX_DEPTH) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR >= n) {
                nextR = 0;
            }
            if (nextR < 0) {
                nextR = n - 1;
            }
            if (nextC >= m) {
                nextC = 0;
            }
            if (nextC < 0) {
                nextC = m - 1;
            }

            dfs(s + world[nextR][nextC], depth + 1, nextR, nextC);
        }
    }
}
