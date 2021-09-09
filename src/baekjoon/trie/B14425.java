package baekjoon.trie;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 14425
 * 문제제목 : 문자열 집합
 * 난이도 : 실버 3
 * 제한사항 : 2초(자바 6초)/1536MB
 * 알고리즘 분류 : 문자열, 트리, 트라이, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 트라이 구현
 *
 * 채점 결과 : 2692ms/873440KB
 * 풀이 날짜 : 2021/08/03
**/

public class B14425 {
    static final int ALPHA_COUNT = 26;
    static Node root;
    static int n, m;

    static class Node {
        Node[] child = new Node[ALPHA_COUNT];
        boolean isLast = false;
        int childCount = 0;
        char value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        root = new Node();
        root.value = ' ';
        for (int i = 0; i < n; i++) {
            insert(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (find(br.readLine())) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void insert(String s) {
        int length = s.length();
        Node cur = root;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
                cur.child[idx].value = c;
                cur.childCount++;
            }

            cur = cur.child[idx];
        }

        cur.isLast = true;
    }

    static boolean find(String s) {
        int length = s.length();
        Node cur = root;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }
        return cur != null && cur.isLast;
    }
}
