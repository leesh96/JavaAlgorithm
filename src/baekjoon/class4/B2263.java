package baekjoon.class4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2263
문제제목 : 트리의 순회
난이도 : 골드 3
제한사항 : 5초/128MB
알고리즘 분류 : 트리, 분할 정복, 재귀

알고리즘 설명
중위 순회 : 왼 -> 루트 -> 오
후위 순회 : 왼 -> 오 -> 루트
전위 순회 : 루트 -> 왼 -> 오
1. 후위 순회 결과로 루트를 찾는다.
2. 찾은 루트를 기준으로 중위 순회의 왼쪽과 오른쪽 서브 트리에서 재귀

채점 결과 : 600ms/72404KB
풀이 날짜 : 2021/11/01
*/

public class B2263 {
    static int n;
    static int[] inOrder, postOrder;
    static HashMap<Integer, Integer> index;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        inOrder = new int[n+1];
        postOrder = new int[n+1];
        index = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
           inOrder[i] = Integer.parseInt(st.nextToken());
           index.put(inOrder[i], i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        answer = new StringBuilder();
        getPreOrder(1, n, 1, n);
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    // 전위 순회 : 루트 -> 왼 -> 오
    // 중위 순회 : 왼 -> 루트 -> 오
    // 후위 순회 : 왼 -> 오 -> 루트
    static void getPreOrder(int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return;
        }

        int curRoot = postOrder[pEnd];
        answer.append(curRoot).append(" ");

        int nextRoot = index.get(curRoot);
        int left = nextRoot - iStart;

        getPreOrder(iStart, nextRoot - 1, pStart, pStart + left - 1);
        getPreOrder(nextRoot + 1, iEnd, pStart + left, pEnd - 1);
    }
}
