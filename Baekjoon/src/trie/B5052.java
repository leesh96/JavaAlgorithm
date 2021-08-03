package trie;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 5052
 * 문제제목 : 전화번호 목록
 * 난이도 : 골드 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 문자열, 정렬, 트리, 트라이
 *
 * 알고리즘 설명
 * 1. 트라이에 전화번호 입력
 * 2. 모든 전화번호에 대해서 전화번호 마지막 숫자에 도달하기 전에 도달하는 문자열이 존재하는지 확인 검증
 *
 * 채점 결과 : 460ms/109924KB
 * 풀이 날짜 : 2021/08/03
**/

public class B5052 {
    static final int NUM_COUNT = 10;
    static Node root;
    static int t, n;
    static String[] tel;

    static class Node {
        Node[] child = new Node[NUM_COUNT];
        boolean isLast = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            n = Integer.parseInt(br.readLine());
            root = new Node();
            tel = new String[n];
            for (int i = 0; i < n; i++) {
                tel[i] = br.readLine();
                insert(tel[i]);
            }

            boolean result = true;
            for (int i = 0; i < n; i++) {
                if (!check(tel[i])) {
                    result = false;
                    break;
                }
            }

            if (result) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void insert(String s) {
        Node cur = root;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int idx = s.charAt(i) - '0';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.isLast = true;
    }

    static boolean check(String s) {
        Node cur = root;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int idx = s.charAt(i) - '0';
            if (cur.isLast) {
                return false;
            }
            cur = cur.child[idx];
        }

        return true;
    }
}
