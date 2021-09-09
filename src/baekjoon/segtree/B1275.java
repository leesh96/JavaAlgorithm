package baekjoon.segtree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1275
 * 문제제목 : 커피숍2
 * 난이도 : 골드 1
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 세그먼트 트리
 *
 * 알고리즘 설명
 * 1. 세그먼트 트리 구현
 * 2. 문제에서 주어진 게임에 맞게 구간합 출력 및 인덱스 값 갱신
 *
 * 채점 결과 : 936ms/93112KB
 * 풀이 날짜 : 2021/07/10
**/

public class B1275 {
    static int n, q;
    static int[] nums;
    static long[] segTree;
    static int segN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (segN = 1; segN < n; segN *= 2);
        segTree = new long[(int)(1 * Math.pow(2, (int)Math.ceil(Math.log10(segN) / Math.log10(2)) + 1))];
        create(0, n - 1, 1);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long sectSum;
            if (x > y) {
                sectSum = sum(0, n - 1, 1, y - 1, x - 1);
            } else {
                sectSum = sum(0, n - 1, 1, x - 1, y - 1);
            }
            bw.write(sectSum + "\n");
            update(0, n - 1, 1, a - 1, b);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long create(int start, int end, int node) {
        if (start == end) {
            return segTree[node] = nums[start];
        }
        int mid = (start + end) / 2;
        return segTree[node] = create(start, mid, node * 2) + create(mid + 1, end, node * 2 + 1);
    }

    static long update(int start, int end, int node, int idx, long value) {
        if (idx < start || idx > end) {
            return segTree[node];
        }

        if (start == end) {
            return segTree[node] = value;
        }

        int mid = (start + end) / 2;
        return segTree[node] = update(start, mid, node * 2, idx, value) + update(mid + 1, end, node * 2 + 1, idx, value);
    }

    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
