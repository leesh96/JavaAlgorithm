package baekjoon.trie;

import java.io.*;
import java.util.HashMap;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9202
 * 문제제목 : Boggle
 * 난이도 : 플래티넘 5
 * 제한사항 : 10초/512MB
 * 알고리즘 분류 : 문자열, 트리, 트라이, 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹, 완전 탐색
 *
 * 알고리즘 설명
 * 1. 단어 사전은 트라이로 관리 -> 찾기도 트라이
 * 2. 모든 Boggle 정점에 대해서 깊이 우선 탐색 -> 각 깊이에서 단어 사전에서 find -> 존재하면 HashMap 마킹, 가장 긴 단어 갱신
 * 3. 깊이가 8이면 더 이상 탐색하지 않는 조건 추가 (무한루프 방지)
 * 4. 2번의 완전 탐색이 끝나면 점수 계산, 찾은 단어 개수 확인
 *
 * 채점 결과 : 3728ms/404200KB
 * 풀이 날짜 : 2021/08/03
**/

public class B9202 {
    static final int ALPHA_COUNT = 26;
    static final int SIZE = 4;
    static final int MAX_DEPTH = 8;
    static Node root;
    static int w, b;
    static char[][] boggle;
    static boolean[][] visit;
    static HashMap<String, Boolean> findMap;
    static int score, count;
    static String longest;

    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Node {
        Node[] child = new Node[ALPHA_COUNT];
        boolean isLast = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        w = Integer.parseInt(br.readLine());
        root = new Node();
        for (int i = 0; i < w; i++) {
            insert(br.readLine());
        }
        br.readLine();
        b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            boggle = new char[SIZE][];
            for (int j = 0; j < SIZE; j++) {
                boggle[j] = br.readLine().toCharArray();
            }
            findMap = new HashMap<>();
            longest = "";
            visit = new boolean[SIZE][SIZE];
            for (int a = 0; a < SIZE; a++) {
                for (int b = 0; b < SIZE; b++) {
                    visit[a][b] = true;
                    dfs(a, b, "" + boggle[a][b], 1);
                    visit[a][b] = false;
                }
            }
            count = findMap.size();
            score = 0;
            for (String s : findMap.keySet()) {
                int length = s.length();
                if (length == 3 || length == 4) {
                    score += 1;
                } else if (length == 5) {
                    score += 2;
                } else if (length == 6) {
                    score += 3;
                } else if (length == 7) {
                    score += 5;
                } else if (length == 8) {
                    score += 11;
                }
            }
            bw.write(score + " " + longest + " " + count + "\n");
            if (i < b - 1) {
                br.readLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, String s, int depth) {
        visit[r][c] = true;

        if (find(s)) {
            int length = s.length();
            if (longest.length() < length) {
                longest = s;
            } else if (longest.length() == length) {
                if (longest.compareTo(s) > 0) {
                    longest = s;
                }
            }
            findMap.put(s, findMap.getOrDefault(s, true));
        }

        if (depth == MAX_DEPTH) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if ((0 <= nextR && nextR < SIZE) && (0 <= nextC && nextC < SIZE) && !visit[nextR][nextC]) {
                dfs(nextR, nextC, s + boggle[nextR][nextC], depth + 1);
                visit[nextR][nextC] = false;
            }
        }
    }

    static void insert(String s) {
        int length = s.length();
        Node cur = root;

        for (int i = 0; i < length; i++) {
            int idx = s.charAt(i) - 'A';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }

        cur.isLast = true;
    }

    static boolean find(String s) {
        int length = s.length();
        Node cur = root;

        for (int i = 0; i < length; i++) {
            int idx = s.charAt(i) - 'A';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }

        return cur != null && cur.isLast;
    }
}
