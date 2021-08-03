package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9934
 * 문제제목 : 완전 이진 트리
 * 난이도 : 실버 1
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현, 트리
 *
 * 알고리즘 설명
 * 완전 이진 트리는 리프 노드를 제외하고 왼쪽과 오른쪽 자식도 완전 이진 트리
 * 주어진 중위 순회 리스트에서 루트를 찾아가면된다.
 * 루트 값을 찾고 왼쪽 부분 트리, 오른쪽 부분 트리로 재귀
 * 깊이가 트리의 깊이와 같아지면 종료
 *
 * 채점 결과 : 184ms/16060KB
 * 풀이 날짜 : 2021/08/03
**/

public class B9934 {
    static int k;
    static ArrayList<Integer>[] level;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        input = new int[(int) Math.pow(2, k) - 1];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            input[idx++] = Integer.parseInt(st.nextToken());
        }
        level = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            level[i] = new ArrayList<>();
        }
        search(0, input.length, 0);
        for (int i = 0; i < k; i++) {
            for (int node : level[i]) {
                bw.write(node + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void search(int start, int end, int depth) {
        if (depth == k) {
            return;
        }
        int mid = (start + end) / 2;
        level[depth].add(input[mid]);
        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}
