package segtree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9426
 * 문제제목 : 중앙값 찾기
 * 난이도 : 플래티넘 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 세그먼트 트리
 *
 * 알고리즘 설명
 * Q. 매 초마다 지난 K초 동안 측정한 온도의 중앙값을 보여준다. -> K 인덱스 부터 n까지 디스플레이에 중앙값이 뜬다.
 * 1. K - 1초 까지(중앙값이 뜨지 않음) 세그먼트 트리에서 매 초 측정한 온도값이 인덱스인 곳의 값을 +1
 * 2. K초 부터 갱신(1.), 중앙값 찾기, k번째 이전의 측정한 온도값의 세그먼트 트리 값을 -1
 * 3. 찾은 중앙값을 합계에 누적
 * 4. 중앙값은 측정값이 (k + 1) / 2개 (세그먼트 트리의 값이 측정값 카운트기 때문에)가 되는 곳을 찾는다. -> 이분 탐색 원리
 *
 * 채점 결과 : 468ms/35384KB
 * 풀이 날짜 : 2021/08/03
**/

public class B9426 {
    static final int MAX_TEMPER = 65536;
    static final int MAX_N = 250001;
    static int n, k;
    static int[] segTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        segTree = new int[MAX_N * 4];
        arr = new int[MAX_N];

//        세그먼트 트리 인덱스 출력
//        System.out.println();
//        for (int i = 0; i < segTree.length; i++) {
//            System.out.printf("%2d ", i);
//        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            update(0, MAX_TEMPER - 1, arr[i], 1, 1);
            // print();
        }

        long sum = 0;
        for (int i = k - 1; i < n; i++) {
            update(0, MAX_TEMPER - 1, arr[i], 1, 1);
            // print();
            sum += search(0, MAX_TEMPER - 1, (k + 1) / 2, 1);
            update(0, MAX_TEMPER - 1, arr[i-k+1], 1, -1);
            // print();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

//    디버깅용 세그먼트 트리 값 출력
//    static void print() {
//        for (int n : segTree) {
//            System.out.printf("%2d ", n);
//        }
//        System.out.println();
//    }

    static int update(int start, int end, int idx, int node, int diff) {
        if (idx < start || idx > end) {
            return segTree[node];
        }

        if (start == end) {
            return segTree[node] += diff;
        }

        int mid = (start + end) / 2;
        return segTree[node] = update(start, mid, idx, node * 2, diff) + update(mid + 1, end, idx, node * 2 + 1, diff);
    }

    static int search(int start, int end, int value, int node) {
        int mid = (start + end) / 2;
        if (start == end) {
            return start;
        }
        if (segTree[node * 2] >= value) {
            return search(start, mid, value, node * 2);
        }
        return search(mid + 1, end, value - segTree[node * 2], node * 2 + 1);
    }
}
